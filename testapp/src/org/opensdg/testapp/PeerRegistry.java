package org.opensdg.testapp;

import java.util.ArrayList;

import javax.xml.bind.DatatypeConverter;

import org.opensdg.java.Connection;

public class PeerRegistry {

    private ArrayList<Connection> list;

    public int add(Connection conn) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null) {
                list.set(i, conn);
                return i;
            }
        }

        list.add(conn);
        return list.size() - 1;
    }

    public Connection get(int i) {
        return i < list.size() ? list.get(i) : null;
    }

    public void remove(int i) {
        if (i == list.size() - 1) {
            list.remove(i);
        } else {
            list.set(i, null);
        }
    }

    public void print() {
        for (int i = 0; i < list.size(); i++) {
            Connection conn = list.get(i);

            if (conn != null) {
                System.out.println("#" + i + "\t" + DatatypeConverter.printHexBinary(list.get(i).getPeerId()));
            }
        }
    }
}
