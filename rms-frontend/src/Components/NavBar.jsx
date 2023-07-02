import React from "react";
import "../CSS/NavBar.css";

const NavBar = (props) => {
  const name = sessionStorage["name"];

  return (
    <>
      <nav className="main-nav">
        <div className="social-media">
          <ul className="social-media-desktop">
            <li>
              <p>{name}</p>
            </li>
          </ul>
        </div>
      </nav>
    </>
  );
};

export default NavBar;
