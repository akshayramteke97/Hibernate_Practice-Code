package in.ineuron.TestApp;

import in.ineuron.TranferApp.ITransferapp;
import in.ineuron.TranferApp.TransferAppImpl;

public class InsertApp {
	public static void main(String[] args) {
		ITransferapp transferapp = new TransferAppImpl();
		String status = transferapp.getTranferApp(26);
		System.out.println(status);
	}
}
