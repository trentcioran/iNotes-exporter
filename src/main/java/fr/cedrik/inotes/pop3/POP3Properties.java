/**
 *
 */
package fr.cedrik.inotes.pop3;

import java.util.Properties;

import fr.cedrik.inotes.INotesProperties;

/**
 * @author C&eacute;drik LIME
 */
public class POP3Properties extends INotesProperties {
	// default values
	public static final String DEFAULT_PORT = "110";//$NON-NLS-1$
	public static final String DEFAULT_S_PORT = "995";//$NON-NLS-1$
	public static final String DEFAULT_SHARED_SECRET = "";//$NON-NLS-1$
	public static final String DEFAULT_S_STORETYPE = "PKCS12";//$NON-NLS-1$
	// additional keys
	private static final String SHUTDOWN_SECRET = "pop3.shutdown";//$NON-NLS-1$
	private static final String SERVER_PORT = "pop3.port";//$NON-NLS-1$
	private static final String SERVER_S_PORT = "pop3s.port";//$NON-NLS-1$
	private static final String SERVER_S_keyStoreName     = "pop3s.keyStoreName";//$NON-NLS-1$
	private static final String SERVER_S_keyStorePassword = "pop3s.keyStorePassword";//$NON-NLS-1$
	private static final String SERVER_S_keyStoreType     = "pop3s.keyStoreType";//$NON-NLS-1$
	private static final String SERVER_S_trustStoreName     = "pop3s.trustStoreName";//$NON-NLS-1$
	private static final String SERVER_S_trustStorePassword = "pop3s.trustStorePassword";//$NON-NLS-1$
	private static final String SERVER_S_trustStoreType     = "pop3s.trustStoreType";//$NON-NLS-1$

	/**
	 *
	 */
	public POP3Properties(String file) {
		super(file);
	}

	/**
	 * @param defaults
	 */
	public POP3Properties(String file, Properties defaults) {
		super(file, defaults);
	}

	@Override
	protected void init(String file) {
		super.init(file);
		setNotesFolderId(DEFAULT_NOTES_FOLDER_ID);
	}

	public int getPOP3ServerPort() {
		return Integer.parseInt(getProperty(SERVER_PORT, DEFAULT_PORT));
	}

	public int getPOP3SServerPort() {
		return Integer.parseInt(getProperty(SERVER_S_PORT, DEFAULT_S_PORT));
	}

	public String getPOP3SKeyStoreName() {
		return getProperty(SERVER_S_keyStoreName);
	}

	public String getPOP3SKeyStorePassword() {
		return getProperty(SERVER_S_keyStorePassword);
	}

	public String getPOP3SKeyStoreType() {
		return getProperty(SERVER_S_keyStoreType, DEFAULT_S_STORETYPE);
	}

	public String getPOP3STrustStoreName() {
		return getProperty(SERVER_S_trustStoreName);
	}

	public String getPOP3STrustStorePassword() {
		return getProperty(SERVER_S_trustStorePassword);
	}

	public String getPOP3STrustStoreType() {
		return getProperty(SERVER_S_trustStoreType, DEFAULT_S_STORETYPE);
	}

	public String getPOP3ShutdownSecret() {
		return getProperty(SHUTDOWN_SECRET, DEFAULT_SHARED_SECRET);
	}

}
