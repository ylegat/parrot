package com.zenika;

import static org.assertj.core.api.Assertions.assertThat;
import static com.zenika.ParrotTypeEnum.AFRICAN;
import static com.zenika.ParrotTypeEnum.EUROPEAN;
import static com.zenika.ParrotTypeEnum.NORWEGIAN_BLUE;
import org.junit.Test;

public class ParrotTest {

    @Test
    public void european_parrot_should_have_speed_equal_to_base_speed() {
        // given
        Parrot parrot = new Parrot(EUROPEAN, 10, 5.5, true);

        // when
        double speed = parrot.getSpeed();

        // then
        assertThat(speed).isEqualTo(12.0);
    }

    @Test
    public void norwegian_parrot_should_have_base_speed_when_not_nailed() {
        // given
        Parrot parrot = new Parrot(NORWEGIAN_BLUE, 10, 5.5, true);

        // when
        double speed = parrot.getSpeed();

        // then
        assertThat(speed).isEqualTo(0.0);
    }

    @Test
    public void norwegian_parrot_should_have_speed_proportional_to_voltage_when_not_nailed() {
        // given
        Parrot parrot = new Parrot(NORWEGIAN_BLUE, 10, 1.5, false);

        // when
        double speed = parrot.getSpeed();

        // then
        assertThat(speed).isEqualTo(18.0);
    }

    @Test
    public void norwegian_parrot_should_have_maximum_speed_when_high_voltage() {
        // given
        Parrot parrot = new Parrot(NORWEGIAN_BLUE, 10, 4, false);

        // when
        double speed = parrot.getSpeed();

        // then
        assertThat(speed).isEqualTo(24.0);
    }

    @Test
    public void african_parrot_should_have_speed_reduced_by_the_load_factor_when_one_coconut() {
        // given
        Parrot parrot = new Parrot(AFRICAN, 1, 10.0, true);

        // when
        double speed = parrot.getSpeed();

        // then
        assertThat(speed).isEqualTo(3.0);
    }

    @Test
    public void african_parrot_should_have_null_speed_when_too_much_loaded() {
        // given
        Parrot parrot = new Parrot(AFRICAN, 2, 10.0, true);

        // when
        double speed = parrot.getSpeed();

        // then
        assertThat(speed).isEqualTo(0.0);
    }

    @Test
    public void african_parrot_should_have_base_speed_when_no_coconut() {
        // given
        Parrot parrot = new Parrot(AFRICAN, 0, 10.0, true);

        // when
        double speed = parrot.getSpeed();

        // then
        assertThat(speed).isEqualTo(12.0);
    }

}
