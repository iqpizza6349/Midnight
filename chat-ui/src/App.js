import React, { useState } from 'react';
import SockJsClient from 'react-stomp';
import './App.css';
import Input from './components/input';
import LoginForm from './components/form';
import Messages from './components/message';
import chatAPI from './services/chatApi';
import { randomColor } from './utils/common';


const SOCKET_URL = 'http://localhost:8080/ws-chat/';

const App = () => {
  const [messages, setMessages] = useState([])
  const [channel, setChannel] = useState("");
  const [user, setUser] = useState(null)

  let onConnected = () => {
    console.log("Connected!!")
  }

  let onMessageReceived = (msg) => {
    console.log('New Message Received!!', msg);
    setMessages(messages.concat(msg));
  }

  let onSendMessage = (msgText) => {
    chatAPI.sendMessage(user.username, msgText, channel).then(res => {
      console.log('Sent', res);
    }).catch(err => {
      console.log('Error Occurred while sending message to api', err);
    })
  }

  let handleLoginSubmit = (username, channel) => {
    console.log(username, " Logged in..");

    setUser({
      username: username,
      color: randomColor()
    });
    chatAPI.joinUser(username, channel).then(res => {
      console.log('join', res);
      setChannel(channel);
    }).catch(err => {
      console.log('Error Occurred while joining channel to api', err);
    })
  }

  // noinspection JSVoidFunctionReturnValueUsed
  return (
      <div className="App">
        {!!user ?
            (
                <>
                  <SockJsClient
                      url={SOCKET_URL}
                      topics={[channel]}
                      onConnect={onConnected}
                      onDisconnect={console.log("Disconnected!")}
                      onMessage={msg => onMessageReceived(msg)}
                      debug={false}
                  />
                  <Messages
                      messages={messages}
                      currentUser={user}
                  />
                  <Input onSendMessage={onSendMessage} />
                </>
            ) :
            <LoginForm onSubmit={handleLoginSubmit} />
        }
      </div>
  )
}

export default App;