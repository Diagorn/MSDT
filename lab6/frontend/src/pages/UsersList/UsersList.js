import React, {  useState, useEffect } from "react";

import UserTable from "../../components/tables/UserTable/UserTable";

export default function UsersList() {

    return (
        <div className="container">
            <UserTable/>
        </div>
    )
}