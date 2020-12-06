package com.ssafy.ssafyrace;

import java.util.*;

public class DrivingInterface {

    public static class CarsInfo {
        public float dist;
        public float to_middle;
        public float speed;
    };

    public static class ObstaclesInfo {
        public float dist;
        public float to_middle;
    };

    public static class CarStateValues {
        public boolean collided;
        public float collision_distance;
        public float speed;
        public float to_middle;
        public float moving_angle;

        public float moving_forward;
        public float lap_progress;
        public float half_road_limit;

        public ArrayList<Float> track_forward_angles = new ArrayList<Float>();
        public ArrayList<ObstaclesInfo> track_forward_obstacles = new ArrayList<ObstaclesInfo>();
        public ArrayList<CarsInfo> opponent_cars_info = new ArrayList<CarsInfo>();
        public ArrayList<Float> distance_to_way_points = new ArrayList<Float>();
    };

    public CarStateValues get_car_state(boolean collided, float collision_distance, float speed, float to_middle,
                                        float moving_angle, float moving_forward, float lap_progress, float half_road_limit,
                                        float[] arg1, float[] arg2, float[] arg3, float[] arg4){

        CarStateValues values = new CarStateValues();

        values.collided = collided;
        values.collision_distance = collision_distance;
        values.speed = speed;
        values.to_middle = to_middle;
        values.moving_angle = moving_angle;
        values.moving_forward = moving_forward;
        values.lap_progress = lap_progress;
        values.half_road_limit = half_road_limit;

        for (float v : arg1) values.track_forward_angles.add(v);
        for (float v : arg2) values.distance_to_way_points.add(v);

        int forward_obstacles_length = arg3.length / 2;
        for(int i = 0; i<forward_obstacles_length; i++) {
            int index = i * 2;
            ObstaclesInfo obstacle_info = new ObstaclesInfo();
            obstacle_info.dist = arg3[index];
            obstacle_info.to_middle = arg3[index+1];
            values.track_forward_obstacles.add(obstacle_info);
        }

        int opponent_cars_length = arg4.length / 3;
        for(int i = 0; i<opponent_cars_length; i++) {
            int index = i * 3;
            CarsInfo opponent_info = new CarsInfo();
            opponent_info.dist = arg4[index];
            opponent_info.to_middle = arg4[index+1];
            opponent_info.speed = arg4[index+2];
            values.opponent_cars_info.add(opponent_info);
        }

        return values;
    };
}
