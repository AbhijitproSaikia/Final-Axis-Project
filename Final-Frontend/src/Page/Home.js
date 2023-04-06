import "../Style/sb-admin-2.scss";
import App from "../App";


function Home() {

  return (

    <div id="wrapper">
      <ul
        className="navbar-nav bg-gradient-dark sidebar sidebar-dark accordion"
        id="accordionSidebar"
      >
        <a
          className="sidebar-brand d-flex align-items-center justify-content-center"
          href="index.html"
        >
          <div className="sidebar-brand-icon rotate-n-15">
            <i className="fas fa-laugh-wink"></i>
          </div>
          <div className="sidebar-brand-text mx-3">
          CREDIT MONITERING UNIT<sup></sup>
          </div>
        </a>

        <hr className="sidebar-divider my-0" />

        <li className="nav-item active">
          <a className="nav-link" href="/">
            <i className="fas fa-fw fa-tachometer-alt"></i>
            <span>Home</span>
          </a>
        </li>

        <span className="dropdown">
          <button className="bg-gradient-dark">
            <a className="nav-link text-white" href="index.html">
              <i className="fas fa-fw fa-tachometer-alt "></i>
              <span>Dashboards</span>
            </a>
          </button>
          <label>
            <input type="checkbox" />
            <ul
              className="navbar-nav bg-gradient-dark sidebar sidebar-dark accordion"
              id="accordionSidebar"
            >
              <li className="nav-item">
                <a
                  className="nav-link collapsed"
                  href="dashboard1"
                  data-toggle="collapse"
                  data-target="#collapseTwo"
                  aria-expanded="true"
                  aria-controls="collapseTwo"
                >
                  <i className="fas fa-fw fa-cog"></i>
                  <span>CBO_SRM_IDs Interest</span>
                </a>
              </li>

              <li className="nav-item">
                <a
                  className="nav-link collapsed"
                  href="dashboard2"
                  data-toggle="collapse"
                  data-target="#collapseTwo"
                  aria-expanded="true"
                  aria-controls="collapseTwo"
                >
                  <i className="fas fa-fw fa-cog"></i>
                  <span>SOL_IDs Interest</span>
                </a>
              </li>

              <li className="nav-item">
                <a
                  className="nav-link collapsed"
                  href="dashboard3"
                  data-toggle="collapse"
                  data-target="#collapseTwo"
                  aria-expanded="true"
                  aria-controls="collapseTwo"
                >
                  <i className="fas fa-fw fa-cog"></i>
                  <span>Blank Email & TG</span>
                </a>
              </li>

              <li className="nav-item">
                <a
                  className="nav-link collapsed"
                  href="dashboard4"
                  data-toggle="collapse"
                  data-target="#collapseTwo"
                  aria-expanded="true"
                  aria-controls="collapseTwo"
                >
                  <i className="fas fa-fw fa-cog"></i>
                  <span>Technical Glitch</span>
                </a>
              </li>

              <li className="nav-item">
                <a
                  className="nav-link collapsed"
                  href="dashboard5"
                  data-toggle="collapse"
                  data-target="#collapseTwo"
                  aria-expanded="true"
                  aria-controls="collapseTwo"
                >
                  <i className="fas fa-fw fa-cog"></i>
                  <span>Good Customers</span>
                </a>
              </li>
            </ul>
          </label>
        </span>
      </ul>
      <div id="content-wrapper" className="d-flex flex-column">
        <div id="content">
          <nav className="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
            <ul className="navbar-nav ml-auto">
              <li className="nav-item dropdown no-arrow d-sm-none">
                <div
                  className="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                  aria-labelledby="searchDropdown"
                >
                  <form className="form-inline mr-auto w-100 navbar-search">
                    <div className="input-group">
                      <input
                        type="text"
                        className="form-control bg-light border-0 small"
                        placeholder="Search for..."
                        aria-label="Search"
                        aria-describedby="basic-addon2"
                      />
                      <div className="input-group-append">
                        <button className="btn btn-primary" type="button">
                          <i className="fas fa-search fa-sm"></i>
                        </button>
                      </div>
                    </div>
                  </form>
                </div>
              </li>
            </ul>
          </nav>

          <div className="container-fluid">
            <App />
          </div>
        </div>
        <footer className="sticky-footer bg-white">
          <div className="container my-auto">
            <div className="copyright text-center my-auto">
              <span>Copyright &copy; Your Website 2023</span>
            </div>
          </div>
        </footer>
      </div>
    </div>
  );
}

export default Home;
