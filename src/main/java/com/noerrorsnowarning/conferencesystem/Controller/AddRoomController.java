package com.noerrorsnowarning.conferencesystem.Controller;

import com.noerrorsnowarning.conferencesystem.Service.EquipmentService;
import com.noerrorsnowarning.conferencesystem.Service.RoomService;
import com.noerrorsnowarning.conferencesystem.domain.Equipment;
import com.noerrorsnowarning.conferencesystem.interceptor.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/html")
public class AddRoomController {

    private RoomService roomService;
    private EquipmentService equipmentService;

    @Autowired
    AddRoomController(RoomService roomService, EquipmentService equipmentService) {
        this.roomService = roomService;
        this.equipmentService = equipmentService;
    }

    @RequestMapping(value = "/addRoom", method = RequestMethod.POST)
    @Access(auths = {"admin"})
    @ResponseBody
    public String addRoom(HttpServletRequest request, Model model) throws ParseException {

        String id = request.getParameter("id");
        System.out.println(id);
//
//        //先获取所有设备列表
//        List<Equipment> equipmentList = equipmentService.getEquips();
//        String[] equip = request.getParameterValues("equip");
//
//        int result = roomService.RoomInsert(request, equip, equipmentList.size());
//
//        if (result == 1) {
//            model.addAttribute("message", "插入成功");
//        } else {
//            model.addAttribute("message", "插入失败");
//        }
//
//        model.addAttribute("equipList", equipmentList);

//        return "html/addmeetingroom.html";
        return "1";
    }

    @RequestMapping(value = "/resetRoom", method = RequestMethod.POST)
    @Access(auths = {"admin"})
    @ResponseBody
    public String resetRoom(HttpServletRequest request) {

        String id = request.getParameter("id");
        System.out.println(id);
        return "1";

    }

}