package com.ssafy.ssafyrace;

public class MyCar {

    boolean is_debug = true;
    static boolean enable_api_control = true; // true(Controlled by code) /false(Controlled by keyboard)

    public void control_driving(boolean a1, float a2, float a3, float a4, float a5, float a6, float a7, float a8,
            float[] a9, float[] a10, float[] a11, float[] a12) {

        // ===========================================================
        // Don't remove this area. ===================================
        // ===========================================================
        DrivingInterface di = new DrivingInterface();
        DrivingInterface.CarStateValues sensing_info = di.get_car_state(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11,
                a12);
        // ===========================================================

        if (is_debug) {
            System.out.println("=========================================================");
            System.out.println("[MyCar] to middle: " + sensing_info.to_middle);

            System.out.println("[MyCar] collided: " + sensing_info.collided);
            System.out.println("[MyCar] car speed: " + sensing_info.speed + "km/h");

            System.out.println("[MyCar] is moving forward: " + sensing_info.moving_forward);
            System.out.println("[MyCar] moving angle: " + sensing_info.moving_angle);
            System.out.println("[MyCar] lap_progress: " + sensing_info.lap_progress);

            StringBuilder forward_angles = new StringBuilder("[MyCar] track_forward_angles: ");
            for (Float track_forward_angle : sensing_info.track_forward_angles) {
                forward_angles.append(track_forward_angle).append(", ");
            }
            System.out.println(forward_angles);

            StringBuilder to_way_points = new StringBuilder("[MyCar] distance_to_way_points: ");
            for (Float distance_to_way_point : sensing_info.distance_to_way_points) {
                to_way_points.append(distance_to_way_point).append(", ");
            }
            System.out.println(to_way_points);

            StringBuilder forward_obstacles = new StringBuilder("[MyCar] track_forward_obstacles: ");
            for (DrivingInterface.ObstaclesInfo track_forward_obstacle : sensing_info.track_forward_obstacles) {
                forward_obstacles.append("{dist:").append(track_forward_obstacle.dist).append(", to_middle:")
                        .append(track_forward_obstacle.to_middle).append("}, ");
            }
            System.out.println(forward_obstacles);

            StringBuilder opponent_cars = new StringBuilder("[MyCar] opponent_cars_info: ");
            for (DrivingInterface.CarsInfo carsInfo : sensing_info.opponent_cars_info) {
                opponent_cars.append("{dist:").append(carsInfo.dist).append(", to_middle:").append(carsInfo.to_middle)
                        .append(", speed:").append(carsInfo.speed).append("km/h}, ");
            }
            System.out.println(opponent_cars);

            System.out.println("=========================================================");
        }

        // ===========================================================
        // Area for writing code about driving rule ==================
        // ===========================================================
        // Editing area starts from here
        //

        //steering : -1 ~ 1(왼쪽  ~ 오른쪽)
        //throttle : -1 ~ 1(후진 ~ 전진)
        //brake : 0 ~ 1 (throttle과 별개로 차량을 정지하거나 감속할 경우 사용 가능)
        //        => penalty를 받을경우 ( 차량이 도로 밖으로 나갈 경우 )0.9로 설정되어 자동 감속됨
        
        float set_throttle = 1.0f;    // 차량 셋팅 일부 변경되어 권장은 0.68 but너무 느림 
        float set_brake = 0.0f;
        
        // 전방의 커브를 조금 더 빨리 인식하기 위해서 track_forward_angles의 속도에 따라 
        // angle을 20 ~ 30m앞서서 가져온다.
        // 10m마다 제공되므로 1, 2번의 배열을 가져오면 된다.
        // 속도에 따라서 빠르면 뒤의 값을, 느리면 앞의 값을 참고한다. 
        int angle_num = (int)(sensing_info.speed/69);
        
        float ref_angle = sensing_info.track_forward_angles.get(angle_num);
        
        //도로의 중간으로 달리려면 middle_add값을 참고하여 달린다.
        float middle_add = (sensing_info.to_middle/73) * -0.8f;
        // 위의 ref_angle값을 참고로 핸들 각을 조정한다.
        // 전방의 커브값에 내 차량의 정면 각도를 빼면 핸들을 틀어야 할 각도가 나온다.
        // 하지만 -1~1인 steering 보다 크므로 이 값을 속도에 따른 비율로 나누어준다.
        float set_steering = (ref_angle - sensing_info.moving_angle) / (220 - sensing_info.speed);
        set_steering += middle_add;
        
//        if(Math.abs(set_steering) > 0.18) {
//            set_brake = 0.11f;
//        }
        
        car_controls.steering = set_steering;
        car_controls.throttle = set_throttle;
        car_controls.brake = set_brake;

        if (is_debug) {
        	System.out.println(sensing_info.track_forward_angles);
//            System.out.println("[MyCar] steering:" + car_controls.steering + ", throttle:" + car_controls.throttle
//                    + ", brake:" + car_controls.brake);
        }

        //
        // Editing area ends
        // =======================================================
    }

    // ===========================================================
    // Don't remove below area. ==================================
    // ===========================================================
    public native int StartDriving(boolean enable_api_control);

    static MyCar car_controls;

    float throttle;
    float steering;
    float brake;

    static {
        System.loadLibrary("DrivingInterface/DrivingInterface");
    }

    public static void main(String[] args) {
        System.out.println("[MyCar] Start Bot! (JAVA)");

        car_controls = new MyCar();
        int return_code = car_controls.StartDriving(enable_api_control);

        System.out.println("[MyCar] End Bot! (JAVA), return_code = " + return_code);

        System.exit(return_code);
    }
    // ===========================================================
}