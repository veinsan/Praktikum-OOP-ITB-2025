public class NeutralResponseStyle implements ResponseStyle {
    @Override
    public String format(String baseResponse) {
        if (baseResponse == null) return "";
        return baseResponse;
    }
    // TODO:
    // Kelas ini harus mengimplementasikan interface ResponseStyle

    // TODO:
    // Kelas ini harus method format dari ResponseStyle dengan ketentuan:
    // 1. Lakukan return "" jika base response bernilai null, jika tidak maka
    // langsung return baseResponse
}
