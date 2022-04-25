import React from 'react';
import {Link} from 'react-router-dom';

const header = (props) => {
    return (
        <header>
            <nav className="navbar navbar-dark bg-dark">
                <div className="container">
                    <div className="d-flex ">
                        <Link className="nav-link " to={"/books"}>Books</Link>
                        <Link className={"nav-link"} to={"/countries"}>Countries</Link>
                        <Link className="nav-link " to={"/authors"}>Authors</Link>
                        <Link className="nav-link " to={"/categories"}>Categories</Link>

                    </div>
                </div>
            </nav>
        </header>
    )

}
export default header;