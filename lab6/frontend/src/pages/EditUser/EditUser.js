import React, {  useState, useEffect  } from "react";
import {  useParams  } from "react-router-dom"

import UserForm from "../../components/forms/UserForm";
import UserService from "../../service/UserService";

export default function EditUser() {
    const { id } = useParams();

    return (
        <div className="container">
            <h1 className="mt-3">{id ? 'Edit user' : 'Add user'}</h1>
            <UserForm
                id={id}
            />
        </div>
    )
}