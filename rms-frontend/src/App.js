import "./App.css";
import { ToastContainer } from "react-toastify";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Home from "./Pages/Home";
import Category from "./Pages/Category";
import Product from "./Pages/Product";
import Orders from "./Pages/Order";
import OrdersChef from "./Pages/OrderChef";
import Tables from "./Pages/Tables";
import User from "./Pages/User";
import Bill from "./Pages/Bill";
import Setting from "./Pages/Setting";
import Logout from "./Pages/Logout";
import Login from "./Pages/Login";

const AuthorizeUser = () => {
  console.log("auth user");
  const loginStatus = sessionStorage["loginStatus"];
  return loginStatus == "1" ? <Home /> : <Login />;
};
const AuthorizeHome = () => {
  const loginStatus = sessionStorage["loginStatus"];
  return loginStatus == "1" ? <Home /> : <Login />;
};
const AuthorizeCategory = () => {
  const loginStatus = sessionStorage["loginStatus"];
  return loginStatus == "1" ? (
    sessionStorage["role"] == "manager" || sessionStorage["role"] == "chef" ? (
      <Category />
    ) : (
      <Home />
    )
  ) : (
    <Login />
  );
};
const AuthorizeProduct = () => {
  const loginStatus = sessionStorage["loginStatus"];
  return loginStatus == "1" ? (
    sessionStorage["role"] == "manager" || sessionStorage["role"] == "chef" ? (
      <Product />
    ) : (
      <Home />
    )
  ) : (
    <Login />
  );
};
const AuthorizeOrders = () => {
  const loginStatus = sessionStorage["loginStatus"];
  return loginStatus == "1" ? (
    sessionStorage["role"] == "manager" ||
    sessionStorage["role"] == "waiter" ? (
      <Orders />
    ) : (
      <Home />
    )
  ) : (
    <Login />
  );
};
const AuthorizeOrdersChef = () => {
  const loginStatus = sessionStorage["loginStatus"];
  return loginStatus == "1" ? (
    sessionStorage["role"] == "chef" ? (
      <OrdersChef />
    ) : (
      <Home />
    )
  ) : (
    <Login />
  );
};
const AuthorizeTables = () => {
  const loginStatus = sessionStorage["loginStatus"];
  return loginStatus == "1" ? (
    sessionStorage["role"] == "manager" ? (
      <Tables />
    ) : (
      <Home />
    )
  ) : (
    <Login />
  );
};
const AuthorizeUsers = () => {
  const loginStatus = sessionStorage["loginStatus"];
  return loginStatus == "1" ? (
    sessionStorage["role"] == "manager" ? (
      <User />
    ) : (
      <Home />
    )
  ) : (
    <Login />
  );
};
const AuthorizeBill = () => {
  const loginStatus = sessionStorage["loginStatus"];
  return loginStatus == "1" ? (
    sessionStorage["role"] == "manager" ||
    sessionStorage["role"] == "cashier" ? (
      <Bill />
    ) : (
      <Home />
    )
  ) : (
    <Login />
  );
};
const AuthorizeSetting = () => {
  const loginStatus = sessionStorage["loginStatus"];
  return loginStatus == "1" ? <Setting /> : <Login />;
};
const AuthorizeLogin = () => {
  const loginStatus = sessionStorage["loginStatus"];
  return loginStatus == "1" ? <Home /> : <Login />;
};
const AuthorizeLogout = () => {
  const loginStatus = sessionStorage["loginStatus"];
  return loginStatus == "1" ? <Logout /> : <Login />;
};

function App() {
  return (
    <div>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<AuthorizeUser />} />
          <Route path="/home" element={<AuthorizeHome />} />
          <Route path="/categories" element={<AuthorizeCategory />} />
          <Route path="/product" element={<AuthorizeProduct />} />
          <Route path="/order" element={<AuthorizeOrders />} />
          <Route path="/orderchef" element={<AuthorizeOrdersChef />} />
          <Route path="/tables" element={<AuthorizeTables />} />
          <Route path="/users" element={<AuthorizeUsers />} />
          <Route path="/bill" element={<AuthorizeBill />} />
          <Route path="/login" element={<AuthorizeLogin />} />
          <Route path="/logout" element={<AuthorizeLogout />} />
          <Route path="/setting" element={<AuthorizeSetting />} />
        </Routes>
      </BrowserRouter>
      <ToastContainer theme="colored" />
    </div>
  );
}

export default App;
