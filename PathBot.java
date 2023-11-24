import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PathBot {
    public static void main(String[] args) {
        Map<String, Object> initialPosition = new HashMap<>();
        initialPosition.put("axis", new int[]{0,0});
        initialPosition.put("direction", "NORTH");

        String[] LEFT = new String[]{"L", "WEST"};
        String[] RIGHT = new String[]{"R", "EAST"};
        String[] NORTH = new String[]{"N", "NORTH"};
        String[] SOUTH = new String[]{"L", "SOUTH"};


        for (String arg : args) {
            String direction = String.valueOf(arg.charAt(0));
            int moveN = Integer.parseInt(arg.substring(2));
            int[] currentAxis = (int[]) initialPosition.get("axis");
            String currentDirection = (String) initialPosition.get("direction");

            if (RIGHT[0].equalsIgnoreCase(direction)) {
                initialPosition.put("axis", new int[]{currentAxis[0] + moveN, currentAxis[1]});
                switch (currentDirection) {
                    case "NORTH":
                        initialPosition.put("direction", RIGHT[1]);
                        break;
                    case "EAST":
                        initialPosition.put("direction", SOUTH[1]);
                        break;
                    case "SOUTH":
                        initialPosition.put("direction", LEFT[1]);
                        break;
                    case "WEST":
                        initialPosition.put("direction", NORTH[1]);
                        break;
                }
            }
            if (LEFT[0].equalsIgnoreCase(direction)) {
                initialPosition.put("axis", new int[]{currentAxis[0] - moveN, currentAxis[1]});
                switch (currentDirection) {
                    case "NORTH":
                        initialPosition.put("direction", LEFT[1]);
                        break;
                    case "WEST":
                        initialPosition.put("direction", SOUTH[1]);
                        break;
                    case "SOUTH":
                        initialPosition.put("direction", RIGHT[1]);
                        break;
                    case "EAST":
                        initialPosition.put("direction", NORTH[1]);
                        break;
                }
            }
        }

        int[] finalPosition = (int[]) initialPosition.get("axis");
        System.out.println(initialPosition.get("direction") + String.format("(%s,%s)", finalPosition[0], finalPosition[1]));
    }
}
