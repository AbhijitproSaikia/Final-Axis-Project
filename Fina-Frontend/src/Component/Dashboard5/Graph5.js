import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Chart } from 'react-google-charts';

export default function Graph5() {
  const [chartData, setChartData] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get('http://localhost:8093/datapilot/dashboard6');
        const data = response.data;

        const chartData = [['CBO_SRM_ID', 'Count']];
        data.forEach((item) => {
          chartData.push([item.cboSrmId, item.count]);
        });

        setChartData(chartData);
      } catch (error) {
        console.log(error);
      }
    };

    fetchData();
  }, []);

  const options = {
    title: 'Dash 5',
    hAxis: {
      title: 'CBO_SRM_ID',
    },
    vAxis: {
      title: 'No. of Good Customers',
    },
    isStacked: true,
  };

  return (
    <div className="App">
      <Chart
        chartType="ColumnChart"
        data={chartData}
        options={options}
        width="100%"
        height="400px"
        legendToggle
      />
    </div>
  );
}
