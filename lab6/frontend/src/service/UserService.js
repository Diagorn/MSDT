import axios from "axios"

const SERVER_URL = 'http://localhost:8080/api/v1/users/'

export default class UserService {
    static async getAllUsers() {
        let res = await axios.get(SERVER_URL)
        let data = res.data
        return data
    }

    static async getUserById(id) {
        let res = await axios.get(SERVER_URL + id)
        let data = res.data
        return data
    }

    static async addUser(user) {
        let res = await axios.post(SERVER_URL + 'add', {
            name: user.name,
            email: user.email,
            gender: user.gender,
            status: user.status
        })
        let data = res.data
        return data
    }

    static async getUserForEditForm(id) {
        let res = await axios.get(SERVER_URL + id + '/edit')
        let data = res.data
        return data
    }

    static async editUser(user, id) {
        let res = await axios.put(SERVER_URL + id, {
            name: user.name,
            email: user.email,
            gender: user.gender,
            status: user.status
        })
        let data = res.data
        return data
    }

    static async deleteById(id) {
        let res = await axios.delete(SERVER_URL + id)
        let data = res.data
        return data
    }
}