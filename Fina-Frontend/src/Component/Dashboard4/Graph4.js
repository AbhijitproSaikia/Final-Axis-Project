
import { Chart } from "react-google-charts";
import axios from "axios";
import { useEffect, useState } from "react";

export default function Dash4() {
  const [data, setData] = useState([]);

  useEffect(() => {
    axios
      .get("http://localhost:8091/datapilot/dashboard4")
      .then((response) => {
        setData(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }, []);

  const chartData = [
    ["_id", "count"],
    ...data.map((item) => [item._id, item.count]),
  ];

  const options = {
    title: "Bar Chart",
    hAxis: {
      title: "No. of Technical Glitch Cases",
    },
    vAxis: {
      title: "CBO_SRM_ID",
    },
  }

  return (
    <div className="App">
      <Chart
        width={"700px"}
        height={"600px"}
        chartType="BarChart"
        loader={<div>Loading Chart</div>}
        data={chartData}
        options={options}
        rootProps={{ "data-testid": "1" }}
      />
    </div>
  );
}



