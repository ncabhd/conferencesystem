package com.noerrorsnowarning.conferencesystem.Service.impl;

import com.noerrorsnowarning.conferencesystem.Service.RoomAndEquipService;
import com.noerrorsnowarning.conferencesystem.domain.Equipment;
import com.noerrorsnowarning.conferencesystem.domain.Room;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomAndEquipServiceImpl implements RoomAndEquipService {

    @Override
    public List<Room> roomAndEquip(List<Room> rooms, List<Equipment> equipmentList) {

        //将设备转为String
        for(int i=0;i<rooms.size();++i){
            String equip=rooms.get(i).getEquip();
            String s="";
            if(equip==null){
                s="无";
            }else {
                for (int j = 0; j < equip.length(); ++j) {
//                    char temp=equip.charAt(j);
                    if(equip.charAt(j)!='0'){
                        s+=equipmentList.get(j).getEname()+" ";
                    }
                }
            }
            rooms.get(i).setEquips(s);
        }

        return rooms;
    }
}
