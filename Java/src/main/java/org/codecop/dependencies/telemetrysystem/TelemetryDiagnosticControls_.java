package org.codecop.dependencies.telemetrysystem;

public class TelemetryDiagnosticControls_ {
    
    private final String DiagnosticChannelConnectionString = "*111#";

    /*
     * The client connects to real hardware and we cannot control it in testing.
     * What to do?
     */
    private TelemetryClient telemetryClient;

    private String diagnosticInfo = "";

    public TelemetryDiagnosticControls_() {
        telemetryClient = new TelemetryClient();
    }

    public String getDiagnosticInfo() {
        return diagnosticInfo;
    }

    public void setDiagnosticInfo(String diagnosticInfo) {
        this.diagnosticInfo = diagnosticInfo;
    }

    public void checkTransmission() throws Exception {
        diagnosticInfo = "";

        telemetryClient.disconnect();

        int retryLeft = 3;
        while (telemetryClient.getOnlineStatus() == false && retryLeft > 0) {
            telemetryClient.connect(DiagnosticChannelConnectionString);
            retryLeft -= 1;
        }

        if (telemetryClient.getOnlineStatus() == false) {
            throw new Exception("Unable to connect.");
        }

        telemetryClient.send(TelemetryClient.DIAGNOSTIC_MESSAGE);
        diagnosticInfo = telemetryClient.receive();
    }
}
