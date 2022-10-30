import React, {  useState, useEffect  } from "react";
import {  Link  } from "react-router-dom"

import UserService from "../../service/UserService";

export default function UserForm(props) {

    const [user, setUser] = useState({
        name: '',
        email: '',
        gender: '',
        status: ''
    })

    useEffect(() => {
        if (props.id !== null) {
            UserService.getUserForEditForm(props.id)
                .then(user => setUser(user))
                .catch(err => console.log(err))
        }
    }, [])

    function onSave() {
        console.log(user)
        console.log(props.id)
        props.id ? 
            UserService.editUser(user, props.id) :
            UserService.addUser(user)
    }

    function onNameChange(e) {
        setUser(prevUser => {
            return {
                ...prevUser,
                name: e.target.value
            }
        })
    }

    function onEmailChange(e) {
        setUser(prevUser => {
            return {
                ...prevUser,
                email: e.target.value
            }
        })
    }

    function onGenderChange(e) {
        setUser(prevUser => {
            return {
                ...prevUser,
                gender: e.target.value
            }
        })
    }

    function onStatusChange(e) {
        setUser(prevUser => {
            return {
                ...prevUser,
                status: e.target.value
            }
        })
    }

    function isGenderSelected(genderValue) {
        return user.gender === genderValue
    }

    function isStatusSelected(activityValue) {
        return user.status === activityValue
    }

    return (
        <>
            <form className="mt-5">
                <div className="mb-3">
                    <label htmlFor="name" className="form-label">Name</label>
                    <input 
                        type="text" 
                        className="form-control" 
                        id="name" 
                        placeholder="Michael Gasin" 
                        value={user.name}
                        onChange={onNameChange}
                    />
                </div>
                <div className="mb-3">
                    <label htmlFor="email" className="form-label">Email address</label>
                    <input 
                        type="email" 
                        className="form-control" 
                        id="email" 
                        aria-describedby="emailHelp" 
                        placeholder="GasinMA@mpei.ru" 
                        value={user.email}
                        onChange={onEmailChange}
                    />
                    <div id="emailHelp" className="form-text">We'll never share your email with anyone else.</div>
                </div>
                <div className="mb-3">
                    <label className="form-label">Gender</label>
                    <div className="form-check">
                        <input 
                            className="form-check-input" 
                            type="radio" 
                            name="gender" 
                            id="male" 
                            value="Male"
                            onChange={onGenderChange}
                            checked={isGenderSelected('Male')}
                        />
                        <label className="form-check-label" htmlFor="male">
                            Male
                        </label>
                    </div>
                    <div className="form-check">
                        <input 
                            className="form-check-input" 
                            type="radio" 
                            name="gender" 
                            id="female" 
                            value="Female"
                            onChange={onGenderChange}
                            checked={isGenderSelected('Female')}
                        />
                        <label className="form-check-label" htmlFor="female">
                            Female
                        </label>
                    </div>
                </div>
                <div className="mb-3">
                    <label className="form-label">Status</label>
                    <div className="form-check">
                        <input 
                            className="form-check-input" 
                            type="radio" 
                            name="status" 
                            id="active" 
                            value="Active"
                            onChange={onStatusChange}
                            checked={isStatusSelected('Active')}
                        />
                        <label className="form-check-label" htmlFor="active">
                            Active
                        </label>
                    </div>
                    <div className="form-check">
                        <input 
                            className="form-check-input" 
                            type="radio" 
                            name="status" 
                            id="inactive" 
                            value="Inactive"
                            onChange={onStatusChange}
                            checked={isStatusSelected('Inactive')}
                        />
                        <label className="form-check-label" htmlFor="inactive">
                            Inactive
                        </label>
                    </div>
                </div>
                <button type="button" className="btn btn-primary" onClick={() => onSave()}>Save</button>
                <Link to="/" className="btn btn-secondary ms-2">Back</Link>
            </form>
        </>
    )
}