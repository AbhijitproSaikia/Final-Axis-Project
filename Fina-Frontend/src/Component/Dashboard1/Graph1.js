
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './Dashboard.css';
import { Chart } from 'react-google-charts';
import { ExportToCsv } from 'export-to-csv'; 

export default function Dash1() {
  const [data, setData] = useState([]);
  const [selectedPoint, setSelectedPoint] = useState({});
  const [filterMin, setFilterMin] = useState('');
  const [filterMax, setFilterMax] = useState('');
  const [filteredData, setFilteredData] = useState([]);
  const [tableData, setTableData] = useState([]);

  useEffect(function fetchData() {
    axios.get('http://localhost:9995/dash1/cbo')
      .then(response => {
        setData(response.data);
      })
      .catch(error => console.log(error));
  }, []);

  const chartData = [['CBO_SRM_ID', 'Total Interest']];
  data.forEach((item) => {
    chartData.push([item._id, item.total_interest]);
  });

  const handleSelection = (selected) => {
    const point = selected[0];
    if (point) {
      setSelectedPoint({
        x: chartData[point.row + 1][0],
        y: chartData[point.row + 1][1]
      });
    } else {
      setSelectedPoint({});
    }
  };

  
  const handleFilter = () => {
    const filteredData = [['CBO_SRM_ID', 'Total Interest']];
    data.forEach((item) => {
      if (
        (filterMin === '' || item.total_interest >= filterMin) &&
        (filterMax === '' || item.total_interest <= filterMax)
      ) {
        filteredData.push([item._id, item.total_interest]);
      }
    });
    return filteredData;
  };
  
  const handleGenerate = () => {
    const filteredData = handleFilter();
    setFilteredData(filteredData);
  };

  const handleDownload = () => {
    const options = {
      fieldSeparator: ',',
      quoteStrings: '"',
      decimalSeparator: '.',
      showLabels: true,
      showTitle: true,
      title: 'Total Interest by CBO_SRM_ID',
      useTextFile: false,
      useBom: true,
      filename: 'total_interest_by_cbo_srm_id',
      useKeysAsHeaders: true,
    };
    const csvExporter = new ExportToCsv(options);
    csvExporter.generateCsv(tableData);
  };

  return (
    <div>
      <h1>Total Interest by CBO_SRM_ID (Dashboard Chart 1)</h1>
      <div className="filter"> 
        <label>
          Min Total Interest:
          <input type="number" value={filterMin} onChange={(e) => setFilterMin(e.target.value)} />
        </label>
        <label>
          Max Total Interest:
          <input type="number" value={filterMax} onChange={(e) => setFilterMax(e.target.value)} />
        </label>
        {/* <button onClick={handleFilter}>Filter</button> */}
      </div>
      <div className="box">
        {Object.keys(selectedPoint).length > 0 && (
          <>
            <div>CBO_SRM_ID: {selectedPoint.x}</div>
            <div>Total Interest: {selectedPoint.y}</div>
          </>
        )}
      </div>
      <Chart
        width={'100%'}
        height={'400px'}
        chartType="ScatterChart"
        loader={<div>Loading Chart...</div>}
        data={handleFilter()}
        options={{
          chart: {
            title: 'Total Interest by CBO_SRM_ID',
            subtitle: 'No. of customers per CBO_SRM_ID',
          },
          legend: { position: 'none' },
          hAxis: { title: 'CBO_SRM_ID', textPosition: 'none' },
          vAxis: { title: 'Total Interest' },
          tooltip: {
            isHtml: true,
            trigger: 'both',
            ignoreBounds: true,
            textStyle: { fontName: 'Arial', fontSize: 12 },
            formatter: function (tooltip) {
              let html = '';
              tooltip.forEach(function (row) {
                html += '<div>' + chartData[row.row + 1][0] + ': ' + chartData[row.row + 1][1] + '</div>';
              });
              return html;
            },
          },
        }}
        chartEvents={[{         eventName: 'select',                    callback: ({ chartWrapper }) => {                        const chart = chartWrapper.getChart();                        handleSelection(chart.getSelection());                    },                },            ]}
      />
      <div className='generate'>
        <button className='button1' onClick={() => setTableData(handleFilter())}>Generate</button>
      </div>
      
      {tableData.length > 0 && (
        
        <div>
          <div className='download'>
            <button className='button1' onClick={() => {
              const csvData = tableData.map(row => row.join(',')).join('\n');
              const blob = new Blob([csvData], { type: 'text/csv' });
              const url = URL.createObjectURL(blob);
              const link = document.createElement('a');
              link.href = url;
              link.setAttribute('download', 'table.csv');
              document.body.appendChild(link);
              link.click();
              document.body.removeChild(link);
            }}>Download</button>
          </div>
          <table>
            <thead>
              <tr>
                {/* <th>CBO_SRM_ID</th>
                <th>Total Interest</th> */}
              </tr>
            </thead>
            <tbody>
              {tableData.map((item, index) => (
                <tr key={index}>
                  <td>{item[0]}</td>
                  <td>{item[1]}</td>
                </tr>
              ))}
            </tbody>
          </table>
          
        </div>
      )}
    </div>
  );
  }  
