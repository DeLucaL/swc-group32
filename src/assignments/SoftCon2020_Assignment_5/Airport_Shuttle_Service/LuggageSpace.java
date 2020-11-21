package assignments.SoftCon2020_Assignment_5.Airport_Shuttle_Service;

public interface LuggageSpace {
    /***
     * this methods returns the available space
     * @return available space
     */
    public String getLuggageSpace();
}

class SmallSpace implements LuggageSpace{
    @Override
    public String getLuggageSpace() {
        return "one bag";
    }
}

class NormalSpace implements LuggageSpace{
    @Override
    public String getLuggageSpace() {
        return "two small and two large bags";
    }
}

class LargeSpace implements LuggageSpace{
    @Override
    public String getLuggageSpace() {
        return "one small and one large bag";
    }
}

class InfiniteSpace implements LuggageSpace{
    @Override
    public String getLuggageSpace() {
        return "no luggage restrictions";
    }
}
