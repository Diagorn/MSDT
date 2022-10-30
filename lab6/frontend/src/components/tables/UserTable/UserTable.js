import React, {  useState, useEffect  } from "react";
import {  Link  } from "react-router-dom"

import UserService from "../../../service/UserService";

export default function UserTable() {

    const [users, setUsers] = useState([])
    
    useEffect(() => {
        UserService.getAllUsers()
            .then(users => setUsers(users))
            .catch(err => console.log(err))
    }, [])

    function onDelete(id) {
        UserService.deleteById(id)
            .then(setUsers(prevUsers => {
                return prevUsers.filter(prevUser => {
                    return prevUser.id !== id
                })
            }))
    }

    function getUsersMarkup() {
        return users.map(user => {
            let editUrl = `/edit/${user.id}`

            return (
                <tr key={user.id}>
                    <th scope="row">{user.id}</th>
                    <td>{user.name}</td>
                    <td>{user.email}</td>
                    <td>{user.gender}</td>
                    <td>{user.status}</td>
                    <td><Link to={editUrl} className="btn btn-link">Edit</Link></td>
                    <td>
                        <button 
                            className="btn btn-danger" 
                            onClick={() => onDelete(user.id)}>
                                Delete
                        </button>
                    </td>
                </tr>
            )
        })
    }

    return (
        <table className="table mt-5">
            <thead className="thead-dark">
                <tr>
                    <th scope="col">id</th>
                    <th scope="col">Name</th>
                    <th scope="col">Email</th>
                    <th scope="col">Gender</th>
                    <th scope="col">Status</th>
                    <th scope="col">Edit</th>
                    <th scope="col">Delete</th>
                </tr>
            </thead>
            <tbody>
                {users && getUsersMarkup()}
            </tbody>
        </table>
    )
}