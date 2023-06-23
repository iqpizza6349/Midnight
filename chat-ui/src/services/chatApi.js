import Axios from "axios";

const api = Axios.create({
    baseURL: '/api/',
});

const chatAPI = {
    getMessages: (groupId) => {
        console.log('Calling get messages from API');
        return api.get(`messages/${groupId}`);
    },

    sendMessage: (username, text, channel) => {
        let msg = {
            sender: username,
            content: text,
            destination: channel
        }
        return api.post(`send`, msg);
    },

    joinUser: (username, channel) => {
        let user = {
            sender: username,
            content: '',
            destination: channel
        }
        return api.post(`join`, user);
    }
}

export default chatAPI;