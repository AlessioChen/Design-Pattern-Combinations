public class NullConverter implements ConversionStrategy{
    @Override
    public String convert(String source) {
        return source;
    }
}
