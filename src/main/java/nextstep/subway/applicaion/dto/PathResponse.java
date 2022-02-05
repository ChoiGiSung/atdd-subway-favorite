package nextstep.subway.applicaion.dto;

import nextstep.subway.domain.Station;

import java.util.List;
import java.util.stream.Collectors;

public class PathResponse {

    private List<StationResponse> stations;
    private double distance;

    public PathResponse() {
    }

    public PathResponse(List<StationResponse> stations, double distance) {
        this.stations = stations;
        this.distance = distance;
    }

    public static PathResponse of(List<Station> shortestPath,double pathWeight) {
        List<StationResponse> stationResponses = shortestPath.stream().map(StationResponse::of).collect(Collectors.toList());
        return new PathResponse(stationResponses,pathWeight);
    }

    public List<StationResponse> getStations() {
        return stations;
    }

    public double getDistance() {
        return distance;
    }
}
