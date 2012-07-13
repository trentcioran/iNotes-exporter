/**
 *
 */
package fr.cedrik.inotes.mbox;

import java.io.IOException;

import org.apache.commons.io.LineIterator;

import fr.cedrik.inotes.MessageMetaData;

/**
 * @author C&eacute;drik LIME
 * @deprecated This format can loose information. Use {@link MBoxrd} instead.
 */
@Deprecated
public class MBoxo extends BaseMBox {

	public MBoxo() throws IOException {
		super();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		new MBoxo().run(args, ".mboxo");
	}

	@Override
	protected void help() {
		System.out.println("Usage: "+MBoxo.class.getSimpleName()+" <out_file> [oldest message to fetch date: " + ISO8601_DATE_SEMITIME + ']');
	}

	@Override
	protected void writeMIME(MessageMetaData message, LineIterator mime) throws IOException {
		writeFromLine(message);
		writeINotesData(message);
		while (mime.hasNext()) {
			String line = mime.nextLine();
			if (line.startsWith("From ")) {
				logger.trace("Escaping {}", line);
				mbox.write('>');
			}
			mbox.append(line).append('\n');
		}
		mbox.write('\n');
	}
}
