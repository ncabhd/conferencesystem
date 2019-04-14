package com.noerrorsnowarning.conferencesystem.Controller;

import com.noerrorsnowarning.conferencesystem.Service.*;
import com.noerrorsnowarning.conferencesystem.domain.Commend;
import com.noerrorsnowarning.conferencesystem.domain.ConferenceInfo;
import com.noerrorsnowarning.conferencesystem.domain.Equipment;
import com.noerrorsnowarning.conferencesystem.domain.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/")
public class BookController {

    private RoomService roomService;
    private EquipmentService equipmentService;
    private RoomAndEquipService roomAndEquipService;
    private ConferenceService conferenceService;

    @Autowired
    BookController(RoomService roomService,
                   EquipmentService equipmentService,
                   RoomAndEquipService roomAndEquipService,
                   ConferenceService conferenceService) {
        this.roomService = roomService;
        this.equipmentService = equipmentService;
        this.roomAndEquipService = roomAndEquipService;
        this.conferenceService = conferenceService;
    }

    @RequestMapping(value = "/html/book.html", method = RequestMethod.GET)
    public String book(Model model) {
        model=setModel(model);
        return "html/book";
    }


    @RequestMapping(value = "/getRoom", method = RequestMethod.POST)
    public String getRoom(HttpServletRequest request,Model model) {

        String roomID = request.getParameter("RoomID");
        String user = (String) request.getSession().getAttribute("Sname");
        ConferenceInfo conferenceInfo=conferenceService.getCon(roomID,user);
        conferenceInfo.setRoomID(roomID);
        model.addAttribute("conInfo",conferenceInfo);
        return "html/book2";
    }

    @RequestMapping(value = "/searchRoom", method = RequestMethod.POST)
    public String searchRoom(HttpServletRequest request, Model model) {

        String roomID = request.getParameter("roomID");
        String roomAddress = request.getParameter("roomAddress");

        List<Room> roomList = roomService.findRoomByIdOrAddress(roomID, roomAddress);
        List<Equipment> equipmentList = equipmentService.getEquips();

        roomList = roomAndEquipService.roomAndEquip(roomList, equipmentList);
        model.addAttribute("equipList", equipmentList);
        model.addAttribute("roomList", roomList);

        return "html/book";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(HttpServletRequest request, Model model) {

        String date = request.getParameter("date");
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        String num = request.getParameter("num");
        String[] equip = request.getParameterValues("equip");

        List<Equipment> equipmentList = equipmentService.getEquips();
        List<Room> roomList = roomService.findRoomEquipByOther(startTime, endTime, num, equip, equipmentList.size());

        roomList = roomAndEquipService.roomAndEquip(roomList, equipmentList);

        model.addAttribute("equipList", equipmentList);
        model.addAttribute("roomList", roomList);

        Commend commend1 = new Commend("2019-04-14", "08:00", "10:00", 10, "asdf");
        Commend commend2 = new Commend("2019-04-14", "08:00", "10:00", 10, "asdf");
        Commend commend3 = new Commend("2019-04-14", "08:00", "10:00", 10, "asdf");

        model.addAttribute("commend1",commend1);
        model.addAttribute("commend2",commend2);
        model.addAttribute("commend3",commend3);

        return "html/book";
    }

    @RequestMapping(value = "/goTo",method = RequestMethod.POST)
    public String goTo(HttpServletRequest request){

        String day=request.getParameter("day");
        String hour=request.getParameter("hour");
        String time=request.getParameter("time");
        System.out.println(day+" "+hour+" "+time);

        return "html/order";
    }

    @RequestMapping(value = "/html/book2.html",method = RequestMethod.GET)
    public String get(){
        return "html/book2";
    }

    @RequestMapping(value = "/html/bookadmin.html", method = RequestMethod.GET)
    public String bookadmin(Model model) {
        model=setModel(model);
        return "html/bookadmin";
    }

    @RequestMapping(value = "/sendOrder",method = RequestMethod.POST)
    public String sendOrder(HttpServletRequest request){
        conferenceService.insertConference(request);
        return "html/book";
    }

    private Model setModel(Model model){

        List<Room> roomList = roomService.getRoom();
        List<Equipment> equipmentList = equipmentService.getEquips();

        model.addAttribute("equipList", equipmentList);

        roomList = roomAndEquipService.roomAndEquip(roomList, equipmentList);

        model.addAttribute("roomList", roomList);

        Commend commend1 = new Commend("2019-04-14", "08:00", "10:00", 10, "asdf");
        Commend commend2 = new Commend("2019-04-14", "08:00", "10:00", 10, "asdf");
        Commend commend3 = new Commend("2019-04-14", "08:00", "10:00", 10, "asdf");

        model.addAttribute("commend1",commend1);
        model.addAttribute("commend2",commend2);
        model.addAttribute("commend3",commend3);
        return model;

    }

}
