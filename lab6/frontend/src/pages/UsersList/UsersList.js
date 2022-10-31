import React from "react";
import {  Link  } from "react-router-dom"

import UserTable from "../../components/tables/UserTable/UserTable";

export default function UsersList() {

    return (
        <div className="container">
            <h1 className="mt-3 d-inline">User list</h1>
            <Link to="/add" className="btn btn-success d-inline mx-5">Add new</Link>
            <UserTable/>
        </div>
    )
}