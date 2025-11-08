public abstract class Chatbot {
    // TODO:
    // Deklarasikan tiga atribut di kelas ini:
    // 1. name (String) bersifat private final untuk menyimpan nama chatbot.
    // 2. responseStyle bersifat private untuk memformat respons.
    // 3. deliveryChannel bersifat private untuk mengirim respons.
    // 4. Silahkan tentukan tipe dari responseStyle dan deliveryChannel berdasarkan
    // spesifikasi soal
    private final String name;
    private ResponseStyle responseStyle;
    private DeliveryChannel deliveryChannel;

    // TODO:
    // Lengkapi konstruktor protected Chatbot(String name, ... responseStyle, ...
    // deliveryChannel) dengan ketentuan:
    // 1. Jika name bernilai null atau blank, gunakan nilai default "Chatbot".
    // 2. Jika responseStyle bernilai null, gunakan instance baru dari
    // NeutralResponseStyle.
    // 3. Jika deliveryChannel bernilai null, gunakan instance baru dari
    // CliDeliveryChannel.
    // 4. Simpan semua nilai yang sudah diproses di atribut yang sesuai.
    protected Chatbot(String name, ResponseStyle responseStyle, DeliveryChannel deliveryChannel) {
        // TODO: Implementasikan sesuai ketentuan di atas.
        if (name == null || name.trim().isEmpty()) {
            this.name = "Chatbot";
        } else {
            this.name = name;
        }
        this.responseStyle = (responseStyle == null) ? new NeutralResponseStyle() : responseStyle;
        this.deliveryChannel = (deliveryChannel == null) ? new CliDeliveryChannel() : deliveryChannel;
    }

    public final void setDeliveryChannel(DeliveryChannel deliveryChannel) {
        // TODO::
        // Jika deliveryChannel bernilai null, gunakan instance baru dari
        // CliDeliveryChannel.
        this.deliveryChannel = (deliveryChannel == null) ? new CliDeliveryChannel() : deliveryChannel;
    }

    public final void setResponseStyle(ResponseStyle responseStyle) {
        // TODO::
        // Jika responseStyle bernilai null, gunakan instance baru dari
        // NeutralResponseStyle.
        this.responseStyle = (responseStyle == null) ? new NeutralResponseStyle() : responseStyle;
    }

    // TODO:
    // Buat method final String getName() yang mengembalikan nilai name.
    public final String getName() {
        // TODO: Return nama chatbot.
        return name;
    }

    // TODO:
    // Buat method final DeliveryChannel getDeliveryChannel() yang mengembalikan
    // nilai
    // deliveryChannel dari kelas ini.
    public final DeliveryChannel getDeliveryChannel() {
        return deliveryChannel; 
    }

    // TODO:
    // Buat method final ResponseStyle getResponseStyle() yang mengembalikan nilai
    // responseStyle dari kelas ini.
    public final ResponseStyle getResponseStyle() {
        return responseStyle;
    }

    // TODO:
    // Buat method final String reply(UserMessage message) dengan ketentuan:
    // 1. Jika message bernilai null, ganti dengan objek UserMessage baru berisi
    // string kosong dan MessageType.UNKNOWN.
    // 2. Jika tipe di dalam message bernilai null, perlakukan sebagai
    // MessageType.UNKNOWN.
    // 3. Gunakan craftResponse untuk mendapatkan base response dari chatbot.
    // 4. Jika base response bernilai null atau blank, gunakan respondToUnknown
    // sebagai gantinya.
    // 5. Format base response menggunakan responseStyle.
    // 6. Return hasil dari deliveryChannel.deliver(formattedResponse, this).
    public final String reply(UserMessage message) {
        // TODO: Implementasikan seluruh langkah di atas.
        if (message == null) {
            message = new UserMessage("", MessageType.UNKNOWN);
        }

        MessageType type = message.getType();
        if (type == null) {
            type = MessageType.UNKNOWN;
        }

        String baseResponse = craftResponse(type, message);
        if (baseResponse == null || baseResponse.trim().isEmpty()) {
            baseResponse = respondToUnknown(message);
        }

        String formatted = responseStyle.format(baseResponse);
        return deliveryChannel.deliver(formatted, this);
    }

    // TODO:
    // Buat method protected String craftResponse(MessageType type, UserMessage
    // message) dengan ketentuan:
    // 1. Jika type bernilai null, perlakukan sebagai MessageType.UNKNOWN.
    // 2. Gunakan switch/if untuk mengarahkan:
    // - MessageType.GREETING memanggil respondToGreeting.
    // - MessageType.QUESTION memanggil respondToQuestion.
    // - Tipe lain memanggil respondToUnknown.
    // 3. Return hasil dari pemanggilan method yang sesuai.
    protected String craftResponse(MessageType type, UserMessage message) {
        // TODO: Implementasikan routing tipe pesan di sini.
        if (type == null) type = MessageType.UNKNOWN;

        switch (type) {
            case GREETING:
                return respondToGreeting(message);
            case QUESTION:
                return respondToQuestion(message);
            default:
                return respondToUnknown(message);
        }
    }

    protected abstract String respondToQuestion(UserMessage message);

    protected abstract String respondToGreeting(UserMessage message);

    // TODO:
    // Buat method protected String respondToUnknown(UserMessage message) yang
    // me-return string default:
    // "I am not sure how to answer that."
    protected String respondToUnknown(UserMessage message) {
        // TODO: Return pesan default sesuai ketentuan.
        return "I am not sure how to answer that.";
    }
}
