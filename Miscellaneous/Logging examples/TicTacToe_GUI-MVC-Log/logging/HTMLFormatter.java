package logging;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

/** Converts each log record to a row in an HTML table. */
public class HTMLFormatter extends Formatter {
    @Override
    public String getHead(Handler handler) {
        return "<!DOCTYPE html>\n<html><head><meta charset=\"UTF-8\">"
                + "<title>Tic Tac Toe Log</title>"
                + "<style>body{font-family:sans-serif}table{border-collapse:collapse}"
                + "th,td{border:1px solid #aaa;padding:8px;text-align:left}"
                + "pre{white-space:pre-wrap}</style></head><body>"
                + "<h1>Tic Tac Toe Log</h1><table>\n"
                + "<tr><th>Time</th><th>Level</th><th>Logger (MVC component)</th>"
                + "<th>Message</th><th>Exception</th></tr>\n";
    }

    @Override
    public String format(LogRecord record) {
        String exception = "";
        if (record.getThrown() != null) {
            StringWriter trace = new StringWriter();
            record.getThrown().printStackTrace(new PrintWriter(trace));
            exception = "<pre>" + escape(trace.toString()) + "</pre>";
        }
        return "<tr><td>" + escape(new Date(record.getMillis()).toString())
                + "</td><td>" + escape(record.getLevel().getName())
                + "</td><td>" + escape(record.getLoggerName())
                + "</td><td>" + escape(formatMessage(record))
                + "</td><td>" + exception + "</td></tr>\n";
    }

    @Override
    public String getTail(Handler handler) {
        return "</table></body></html>\n";
    }

    // Messages are text, not HTML: escape special characters before writing them.
    private static String escape(String text) {
        return text == null ? "" : text.replace("&", "&amp;")
                .replace("<", "&lt;").replace(">", "&gt;")
                .replace("\"", "&quot;").replace("'", "&#39;");
    }
}
