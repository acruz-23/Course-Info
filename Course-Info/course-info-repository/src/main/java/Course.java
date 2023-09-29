public record Course(String id, String name, long length, String url) {
    public Course {
        filled(id);
        filled(name);
        filled(id);
    }

    private static void filled(String s){
        if(s == null || s.isBlank()){
            throw new IllegalArgumentException("No value present!");
        }
    }
}
