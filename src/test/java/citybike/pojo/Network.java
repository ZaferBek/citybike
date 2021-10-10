package citybike.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Network {
        private List<String> company;
        private String href;
        private String id;
        public Location location;
        private String name;
        private String source;
}




