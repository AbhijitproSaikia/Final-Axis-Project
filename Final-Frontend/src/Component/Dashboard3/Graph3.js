import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Chart } from 'react-google-charts';

export default function Graph3() {
  const [chartData, setChartData] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get('http://localhost:9996/datapilot/dashboard3');
        const data = response.data;

        const chartData = [['SOL_ID', 'Failure Count', 'Blank Email Count', 'Total Count']];
        data.forEach((item) => {
          chartData.push([item.solId, item.failureCount, item.blankEmailCount, item.totalCount]);
        });

        setChartData(chartData);
      } catch (error) {
        console.log(error);
      }
    };

    fetchData();
  }, []);

  const options = {
    title: 'Dash 3',
    hAxis: {
      title: 'SOL_ID',
    },
    vAxis: {
      title: 'No. of Customers',
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
