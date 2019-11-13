package de.tum.cs.i1.pse.car;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import de.tum.cs.i1.pse.InstrumentPanel;
import de.tum.cs.i1.pse.instruments.Instrument;

public class UserCar extends Car {
    public static Image DEFAULT_IMAGE;
    
    private ArrayList<Instrument> instruments = new ArrayList<Instrument>();
    
    private InstrumentPanel instrumentPanel;

    public UserCar(int max_x, int max_y) {
        super(max_x, max_y);
        setBody(DEFAULT_IMAGE);
        instrumentPanel = new InstrumentPanel(this);
        reset(max_x, max_y);
    }
    
    public void reset(int max_x, int max_y) {
        this.position.x = 0;
        this.position.y = max_y;
        setDirection(90);
        this.speed = 5;
        this.isCrunched = false;
	}

    public void subscribeInstrument(Instrument component) {
        if (component != null && !this.instruments.contains(component)) {
            this.instruments.add(component);
        }
    }

    public synchronized void notifyInstruments() {
        Iterator<Instrument> iter = instruments.iterator();
        while (iter.hasNext()) {
            Instrument aComponent = iter.next();
            aComponent.updateInstrument();
        }
    }

    public List<Instrument> getInstruments() {
        return instruments;
    }

    public synchronized void updatePosition(int max_x, int max_y) {
        super.updatePosition(max_x, max_y);
        notifyInstruments();
    }

    public InstrumentPanel getInstrumentPanel() {
        return this.instrumentPanel;
    }
}
