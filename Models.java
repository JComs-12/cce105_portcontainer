package comision;

public class Models {

    public static class Container {
    	
        private String id;
        private String description;
        private int weight;

        public Container(String id, String description, int weight) {
            this.id = id;
            this.description = description;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return String.format("%s | %s | %dkg", id, description, weight);
        }
    }

    	public static class Ship {
        private String name;
        private String captain;

        public Ship(String name, String captain) {
            this.name = name;
            this.captain = captain;
        }

        @Override
        public String toString() {
            return String.format("%s | Capt. %s", name, captain);
        }
    }
}
