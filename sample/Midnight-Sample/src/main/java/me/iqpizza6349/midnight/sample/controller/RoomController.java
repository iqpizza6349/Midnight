package me.iqpizza6349.midnight.sample.controller;

import me.iqpizza6349.midnight.sample.vo.CreateRoomRequest;
import me.iqpizza6349.midnight.sample.vo.RoomVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Value("${midnight.topic}")
    private String topic;

    @Value("${midnight.group-id}")
    private String group;

    @Value("${midnight.destination}")
    private String destination;

    /**
     * create room to connect and chat
     * @param roomRequest alias of room
     * @return room data for connect to room such as topic, group-id, etc..
     */
    @PostMapping
    public RoomVO createRoom(@RequestBody CreateRoomRequest roomRequest) {
        return new RoomVO(topic, group, destination);
    }
}
