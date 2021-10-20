package Entities;

public class Travellers {
    private int rooms;
    private int adults;
    private int kids;
    private int[] kidsAges;
    private String country;

    public Travellers(int rooms, int adults, int kids, int[] kidsAges, String country) {

        if (rooms <= 0) {
            this.rooms = 1;
        } else {
            this.rooms = rooms;
        }
        this.adults = adults;
        this.kids = kids;
        if (kids == kidsAges.length) {
            this.kidsAges = kidsAges;
        } else {
            this.kidsAges = null;
        }
        this.country = country;
    }

    public Travellers(int rooms, int adults, int kids) {
        this.rooms = rooms;
        this.adults = adults;
        this.kids = kids;
        this.kidsAges = null;
        this.country = null;
    }

    public int getRooms() {
        return rooms;
    }

    public int getAdults() {
        return adults;
    }

    public int getKids() {
        return kids;
    }

    public int[] getKidsAges() {
        return kidsAges;
    }

    public String getCountry() {
        return country;
    }
}
