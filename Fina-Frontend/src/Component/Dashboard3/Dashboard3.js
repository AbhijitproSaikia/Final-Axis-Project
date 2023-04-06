import React, { useState, useEffect } from "react"
import ReactDOM from "react-dom"
import Pagination from "https://cdn.skypack.dev/rc-pagination@3.1.15";
//import datatableUsers from './response.json'
import Graph3 from "./Graph3"
import { CSVLink, CSVDownload } from "react-csv"
import axios from 'axios'

const Dashboard3 = () => {
    const [perPage, setPerPage] = useState(10);
    const [size, setSize] = useState(perPage);
    const [current, setCurrent] = useState(1);
    const [showGraph, setGraph] = useState(0);
    const [data, setData] = useState([]);


    useEffect(function fetchData() {
        axios.get('http://localhost:9996/datapilot/dashboard3')
            .then(response => {
                console.log('response', response)
                setData(response.data);
            })
            .catch(error => console.log(error))
    }, [])


    const PerPageChange = (value) => {
        setSize(value);
        const newPerPage = Math.ceil(data.length / value);
        if (current > newPerPage) {
            setCurrent(newPerPage);
        }
    }

    const getData = (current, pageSize) => {
        // Normally you should get the data from the server
        return data.slice((current - 1) * pageSize, current * pageSize);
    };

    const PaginationChange = (page, pageSize) => {
        setCurrent(page);
        setSize(pageSize)
    }

    const PrevNextArrow = (current, type, originalElement) => {
        if (type === 'prev') {
            return <button><i className="fa fa-angle-double-left"></i></button>;
        }
        if (type === 'next') {
            return <button><i className="fa fa-angle-double-right"></i></button>;
        }
        return originalElement;
    }

    return (
        <div className="col-md-12">
        <div className="d-sm-flex align-items-center justify-content-between mb-4">
            <h1 className="h3 mb-0 text-gray-800">SOL_IDs wise Technical Glitch and Blank Email Cases</h1>
            <a href="#"
                className="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm report-download"
                onClick={() => {
                    setGraph(!showGraph)
                }}
            >{!showGraph ? 'Generate Report' : 'Back To Dashboard'}</a>
            <a>
                <i className="fas fa-download fa-sm text-black-50"></i>
                <CSVLink className="d-sm-inline-block btn btn-sm btn-primary shadow-sm"
                    data={data} filename={"REPORT 3 Technical Glitch and Blank Email Cases.csv"}>Download Report</CSVLink>
            </a>
        </div>
        {showGraph ? <Graph3 /> :
            <div className="card">
                <div className="card-body p-0">
                    <div className="table-responsive">
                        <table className="table table-text-small mb-0">
                            <thead className="thead-primary text-white table-sorting">
                                <tr>
                                    <th>Sr No</th>
                                    <th>SOL_ID</th>
                                    <th>Failure Count</th>
                                    <th>Blank Email Count</th>
                                    <th>Total Count</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    getData(current, size).map((data, index) => {
                                        return (
                                            <tr key={data.solId}>
                                                <td>{index + 1}</td>
                                                <td>{data.solId}</td>
                                                <td>{data.failureCount}</td>
                                                <td>{data.blankEmailCount}</td>
                                                <td>{data.totalCount}</td>
                                            </tr>
                                        )
                                    })
                                }
                            </tbody>
                        </table>
                    </div>
                    <div className="table-filter-info">

                        <Pagination
                            className="pagination-data"
                            showTotal={(total, range) => `Showing ${range[0]}-${range[1]} of ${total}`}
                            onChange={PaginationChange}
                            total={data.length}
                            current={current}
                            pageSize={size}
                            showSizeChanger={false}
                            itemRender={PrevNextArrow}
                            onShowSizeChange={PerPageChange}
                        />
                    </div>
                </div>
            </div>}
        </div>
    );
};

export default Dashboard3;