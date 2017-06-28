package gr.kouzzzina.kouzzinaApp.retrofit.model;

import java.util.List;

/**
 * Created by mmam on 28/6/2017.
 */

public class test {

    private List<String> self;

    public List<String> getSelf() {
        return self;
    }

    public void setSelf(List<String> self) {
        this.self = self;
    }

    @Override
    public String toString() {
        return "test{" +
                "self=" + self +
                '}';
    }
}
