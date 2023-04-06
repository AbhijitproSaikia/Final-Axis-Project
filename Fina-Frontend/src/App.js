import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
// import Home from './Page/Home';
import Dashboard1 from '../src/Component/Dashboard1/Dashboard1';
import Dashboard2 from '../src/Component/Dashboard2/Dashboard2';
import Dashboard3 from '../src/Component/Dashboard3/Dashboard3';
import Dashboard4 from './Component/Dashboard4/Dashboard4';
import Dashboard5 from './Component/Dashboard5/Dashboard5';
// import Dashboard4 from '../src/Component/Dashboard4/dashboard4';
// import Dash1 from './component2/Dash1';
// import Dash1Chart from './component2/Dash1Chart';

function App() {
    return (
        <div className='App'>
            <BrowserRouter>
                <Routes>
                    <Route path="/dashboard1" element={<Dashboard1 />} />
                    <Route path="/dashboard2" element={<Dashboard2 />} />
                    <Route path="/dashboard3" element={<Dashboard3 />} />
                    <Route path="/dashboard4" element={<Dashboard4 />} />
                    <Route path="/dashboard5" element={<Dashboard5 />} />
                    {/* <Route path="/dashboard4" element={<Dashboard4 />} /> */}
                    {/* <Route path="/table1" element={<Table1 />} /> */}
                    {/* <Route path="/dash1" element={<Dash1 />} /> */}
                    {/* <Route path="/dash1chart" element={<Dash1Chart />} /> */}
                </Routes>
            </BrowserRouter>
        </div>
    );
}

export default App;
