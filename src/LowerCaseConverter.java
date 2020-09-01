public class LowerCaseConverter implements ConversionStrategy {
    @Override
    public String convert(String source) {
        return source.toLowerCase();
    }
}
