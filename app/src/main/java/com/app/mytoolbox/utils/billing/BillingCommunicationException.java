package com.app.mytoolbox.utils.billing;

public class BillingCommunicationException extends Exception
{

    public BillingCommunicationException(Throwable cause)
    {
        super(cause);
    }

    public BillingCommunicationException(String message)
    {
        super(message);
    }
}
