import React, { useState } from 'react';
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';

const Form = ({ onSubmit }) => {

    const [username, setUsername] = useState("");
    const [channel, setChannel] = useState("");
    let handleUserNameChange = event => setUsername(event.target.value);
    let handleChannelChange = event => setChannel("/topic/" + event.target.value);

    let handleSubmit = () => {
        onSubmit(username, channel);
    }

    return (
        <div>
            <TextField
                label="Type to enter channel"
                placeholder="channel name"
                onChange={handleChannelChange}
                margin="normal"
            />
            <TextField
                label="Type your username"
                placeholder="Username"
                onChange={handleUserNameChange}
                margin="normal"
            />
            <br />
            <Button variant="contained" color="primary" onClick={handleSubmit} >
                Login
            </Button>

        </div>
    )
}

export default Form