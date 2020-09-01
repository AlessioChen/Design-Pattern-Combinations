public class UpperCaseConverter implements ConversionStrategy {

    @Override
    public String convert(String source) {
        return source.toUpperCase();
    }
}
