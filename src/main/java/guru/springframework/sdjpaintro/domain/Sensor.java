package guru.springframework.sdjpaintro.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sensor", schema = "bookstore")
public class Sensor
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    protected String type;

    // Sensor Position X (ECEF) (m)
    @Column(name = "sensor_pos_x")
    protected Float sensorPosX;

    // Sensor Position Y (ECEF) (m)
    @Column(name = "sensor_pos_y")
    protected Float sensorPosY;

    // Sensor Position Z (ECEF) (m)
    @Column(name = "sensor_pos_z")
    protected Float sensorPosZ;
}
