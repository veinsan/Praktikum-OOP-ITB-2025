public class FormalResponseStyle implements ResponseStyle {
    @Override
    public String format(String baseResponse) {
        return "Dear user, " + baseResponse + " Sincerely.";
    }
    // TODO:
    // Kelas ini harus mengimplementasikan interface ResponseStyle

    // TODO:
    // Kelas ini harus method format dari ResponseStyle dengan ketentuan:
    // 1. Lakukan return: "Dear user, <response> Sincerely."
}
