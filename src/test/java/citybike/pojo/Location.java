package citybike.pojo;

import lombok.Data;

@Data
public class Location {
        public String city;
        private String country;
        private double latitude;
        private double longitude;

}
