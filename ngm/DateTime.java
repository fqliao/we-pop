package cn.webank.blockchain.contracts.web3j;

import java.math.BigInteger;
import java.util.Arrays;
import org.fisco.bcos.web3j.abi.TypeReference;
import org.fisco.bcos.web3j.abi.datatypes.Bool;
import org.fisco.bcos.web3j.abi.datatypes.Function;
import org.fisco.bcos.web3j.abi.datatypes.Type;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint16;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint256;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint8;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.RemoteCall;
import org.fisco.bcos.web3j.tx.Contract;
import org.fisco.bcos.web3j.tx.TransactionManager;
import org.fisco.bcos.web3j.tx.gas.ContractGasProvider;
import org.fisco.bcos.web3j.tx.txdecode.TransactionDecoder;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.fisco.bcos.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version none.
 */
@SuppressWarnings("unchecked")
public class DateTime extends Contract {
    public static String BINARY = "608060405234801561001057600080fd5b50610d9a806100206000396000f3006080604052600436106100d0576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680633e239e1a146100d55780634ac1ad781461011c57806362ba96871461016357806365c72840146101dc5780637f791833146102235780638aa001fc1461028f5780638c8d98a0146102d65780639054bdec1461033557806392d66313146103bb578063a324ad2414610404578063a6f0e5771461044b578063b199993714610494578063b238ad0e146104d5578063fa93f8831461052d575b600080fd5b3480156100e157600080fd5b5061010060048036038101908080359060200190929190505050610574565b604051808260ff1660ff16815260200191505060405180910390f35b34801561012857600080fd5b50610147600480360381019080803590602001909291905050506105a1565b604051808260ff1660ff16815260200191505060405180910390f35b34801561016f57600080fd5b506101c6600480360381019080803561ffff169060200190929190803560ff169060200190929190803560ff169060200190929190803560ff169060200190929190803560ff1690602001909291905050506105c8565b6040518082815260200191505060405180910390f35b3480156101e857600080fd5b50610207600480360381019080803590602001909291905050506105e4565b604051808260ff1660ff16815260200191505060405180910390f35b34801561022f57600080fd5b50610279600480360381019080803561ffff169060200190929190803560ff169060200190929190803560ff169060200190929190803560ff1690602001909291905050506105fa565b6040518082815260200191505060405180910390f35b34801561029b57600080fd5b506102ba60048036038101908080359060200190929190505050610615565b604051808260ff1660ff16815260200191505060405180910390f35b3480156102e257600080fd5b5061031f600480360381019080803561ffff169060200190929190803560ff169060200190929190803560ff16906020019092919050505061062b565b6040518082815260200191505060405180910390f35b34801561034157600080fd5b506103a5600480360381019080803561ffff169060200190929190803560ff169060200190929190803560ff169060200190929190803560ff169060200190929190803560ff169060200190929190803560ff169060200190929190505050610646565b6040518082815260200191505060405180910390f35b3480156103c757600080fd5b506103e6600480360381019080803590602001909291905050506108ed565b604051808261ffff1661ffff16815260200191505060405180910390f35b34801561041057600080fd5b5061042f60048036038101908080359060200190929190505050610998565b604051808260ff1660ff16815260200191505060405180910390f35b34801561045757600080fd5b5061047a600480360381019080803561ffff1690602001909291905050506109ae565b604051808215151515815260200191505060405180910390f35b3480156104a057600080fd5b506104bf60048036038101908080359060200190929190505050610a2f565b6040518082815260200191505060405180910390f35b3480156104e157600080fd5b50610511600480360381019080803560ff169060200190929190803561ffff169060200190929190505050610a68565b604051808260ff1660ff16815260200191505060405180910390f35b34801561053957600080fd5b5061055860048036038101908080359060200190929190505050610b34565b604051808260ff1660ff16815260200191505060405180910390f35b60006018603c808481151561058557fe5b0481151561058f57fe5b0481151561059957fe5b069050919050565b60006007600462015180848115156105b557fe5b04018115156105c057fe5b069050919050565b60006105d986868686866000610646565b905095945050505050565b60006105ef82610b55565b604001519050919050565b600061060b85858585600080610646565b9050949350505050565b6000603c8281151561062357fe5b069050919050565b600061063d8484846000806000610646565b90509392505050565b600080610651610cf6565b6107b291505b8861ffff168261ffff16101561069a57610670826109ae565b15610683576301e285008301925061068d565b6301e13380830192505b8180600101925050610657565b601f816000600c811015156106ab57fe5b602002019060ff16908160ff16815250506106c5896109ae565b156106f157601d816001600c811015156106db57fe5b602002019060ff16908160ff1681525050610714565b601c816001600c8110151561070257fe5b602002019060ff16908160ff16815250505b601f816002600c8110151561072557fe5b602002019060ff16908160ff1681525050601e816003600c8110151561074757fe5b602002019060ff16908160ff1681525050601f816004600c8110151561076957fe5b602002019060ff16908160ff1681525050601e816005600c8110151561078b57fe5b602002019060ff16908160ff1681525050601f816006600c811015156107ad57fe5b602002019060ff16908160ff1681525050601f816007600c811015156107cf57fe5b602002019060ff16908160ff1681525050601e816008600c811015156107f157fe5b602002019060ff16908160ff1681525050601f816009600c8110151561081357fe5b602002019060ff16908160ff1681525050601e81600a600c8110151561083557fe5b602002019060ff16908160ff1681525050601f81600b600c8110151561085757fe5b602002019060ff16908160ff1681525050600191505b8760ff168261ffff1610156108af57806001830361ffff16600c8110151561089157fe5b602002015160ff16620151800283019250818060010192505061086d565b6001870360ff166201518002830192508560ff16610e1002830192508460ff16603c02830192508360ff168301925082925050509695505050505050565b600080600080600092506301e133808581151561090657fe5b046107b261ffff160191506109206107b261ffff16610a2f565b61092d8361ffff16610a2f565b039050806301e285000283019250806107b2830361ffff16036301e1338002830192505b8483111561098d57610965600183036109ae565b15610978576301e2850083039250610982565b6301e13380830392505b600182039150610951565b819350505050919050565b60006109a382610b55565b602001519050919050565b60008060048361ffff168115156109c157fe5b0661ffff161415156109d65760009050610a2a565b600060648361ffff168115156109e857fe5b0661ffff161415156109fd5760019050610a2a565b60006101908361ffff16811515610a1057fe5b0661ffff16141515610a255760009050610a2a565b600190505b919050565b600060018203915061019082811515610a4457fe5b04606483811515610a5157fe5b04600484811515610a5e57fe5b0403019050919050565b600060018360ff161480610a7f575060038360ff16145b80610a8d575060058360ff16145b80610a9b575060078360ff16145b80610aa9575060088360ff16145b80610ab75750600a8360ff16145b80610ac55750600c8360ff16145b15610ad357601f9050610b2e565b60048360ff161480610ae8575060068360ff16145b80610af6575060098360ff16145b80610b045750600b8360ff16145b15610b1257601e9050610b2e565b610b1b826109ae565b15610b2957601d9050610b2e565b601c90505b92915050565b6000603c8083811515610b4357fe5b04811515610b4d57fe5b069050919050565b610b5d610d1a565b60008060008060009350610b70866108ed565b856000019061ffff16908161ffff1681525050610b926107b261ffff16610a2f565b610ba3866000015161ffff16610a2f565b039250826301e285000284019350826107b286600001510361ffff16036301e133800284019350600191505b600c8260ff16111515610c2757610bea828660000151610a68565b60ff1662015180029050858482011115610c155781856020019060ff16908160ff1681525050610c27565b80840193508180600101925050610bcf565b600191505b610c3e85602001518660000151610a68565b60ff168260ff16111515610c8557858462015180011115610c705781856040019060ff16908160ff1681525050610c85565b62015180840193508180600101925050610c2c565b610c8e86610574565b856060019060ff16908160ff1681525050610ca886610b34565b856080019060ff16908160ff1681525050610cc286610615565b8560a0019060ff16908160ff1681525050610cdc866105a1565b8560c0019060ff16908160ff168152505050505050919050565b61018060405190810160405280600c90602082028038833980820191505090505090565b60e060405190810160405280600061ffff168152602001600060ff168152602001600060ff168152602001600060ff168152602001600060ff168152602001600060ff168152602001600060ff16815250905600a165627a7a72305820c1f2a8c1cb7918342e9e5e45548031a831f03eca92f5c2d649e83a89b4f7ccef0029";

    public static final String ABI = "[{\"constant\":true,\"inputs\":[{\"name\":\"timestamp\",\"type\":\"uint256\"}],\"name\":\"getHour\",\"outputs\":[{\"name\":\"\",\"type\":\"uint8\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"timestamp\",\"type\":\"uint256\"}],\"name\":\"getWeekday\",\"outputs\":[{\"name\":\"\",\"type\":\"uint8\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"year\",\"type\":\"uint16\"},{\"name\":\"month\",\"type\":\"uint8\"},{\"name\":\"day\",\"type\":\"uint8\"},{\"name\":\"hour\",\"type\":\"uint8\"},{\"name\":\"minute\",\"type\":\"uint8\"}],\"name\":\"toTimestamp\",\"outputs\":[{\"name\":\"timestamp\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"timestamp\",\"type\":\"uint256\"}],\"name\":\"getDay\",\"outputs\":[{\"name\":\"\",\"type\":\"uint8\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"year\",\"type\":\"uint16\"},{\"name\":\"month\",\"type\":\"uint8\"},{\"name\":\"day\",\"type\":\"uint8\"},{\"name\":\"hour\",\"type\":\"uint8\"}],\"name\":\"toTimestamp\",\"outputs\":[{\"name\":\"timestamp\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"timestamp\",\"type\":\"uint256\"}],\"name\":\"getSecond\",\"outputs\":[{\"name\":\"\",\"type\":\"uint8\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"year\",\"type\":\"uint16\"},{\"name\":\"month\",\"type\":\"uint8\"},{\"name\":\"day\",\"type\":\"uint8\"}],\"name\":\"toTimestamp\",\"outputs\":[{\"name\":\"timestamp\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"year\",\"type\":\"uint16\"},{\"name\":\"month\",\"type\":\"uint8\"},{\"name\":\"day\",\"type\":\"uint8\"},{\"name\":\"hour\",\"type\":\"uint8\"},{\"name\":\"minute\",\"type\":\"uint8\"},{\"name\":\"second\",\"type\":\"uint8\"}],\"name\":\"toTimestamp\",\"outputs\":[{\"name\":\"timestamp\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"timestamp\",\"type\":\"uint256\"}],\"name\":\"getYear\",\"outputs\":[{\"name\":\"\",\"type\":\"uint16\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"timestamp\",\"type\":\"uint256\"}],\"name\":\"getMonth\",\"outputs\":[{\"name\":\"\",\"type\":\"uint8\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"year\",\"type\":\"uint16\"}],\"name\":\"isLeapYear\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"year\",\"type\":\"uint256\"}],\"name\":\"leapYearsBefore\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"month\",\"type\":\"uint8\"},{\"name\":\"year\",\"type\":\"uint16\"}],\"name\":\"getDaysInMonth\",\"outputs\":[{\"name\":\"\",\"type\":\"uint8\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"timestamp\",\"type\":\"uint256\"}],\"name\":\"getMinute\",\"outputs\":[{\"name\":\"\",\"type\":\"uint8\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"}]";

    public static final TransactionDecoder transactionDecoder = new TransactionDecoder(ABI, BINARY);

    public static final String FUNC_GETHOUR = "getHour";

    public static final String FUNC_GETWEEKDAY = "getWeekday";

    public static final String FUNC_TOTIMESTAMP = "toTimestamp";

    public static final String FUNC_GETDAY = "getDay";

    public static final String FUNC_GETSECOND = "getSecond";

    public static final String FUNC_GETYEAR = "getYear";

    public static final String FUNC_GETMONTH = "getMonth";

    public static final String FUNC_ISLEAPYEAR = "isLeapYear";

    public static final String FUNC_LEAPYEARSBEFORE = "leapYearsBefore";

    public static final String FUNC_GETDAYSINMONTH = "getDaysInMonth";

    public static final String FUNC_GETMINUTE = "getMinute";

    @Deprecated
    protected DateTime(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected DateTime(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected DateTime(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected DateTime(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static TransactionDecoder getTransactionDecoder() {
        return transactionDecoder;
    }

    public RemoteCall<BigInteger> getHour(BigInteger timestamp) {
        final Function function = new Function(FUNC_GETHOUR, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(timestamp)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> getWeekday(BigInteger timestamp) {
        final Function function = new Function(FUNC_GETWEEKDAY, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(timestamp)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> toTimestamp(BigInteger year, BigInteger month, BigInteger day, BigInteger hour, BigInteger minute) {
        final Function function = new Function(FUNC_TOTIMESTAMP, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint16(year), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint8(month), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint8(day), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint8(hour), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint8(minute)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> getDay(BigInteger timestamp) {
        final Function function = new Function(FUNC_GETDAY, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(timestamp)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> toTimestamp(BigInteger year, BigInteger month, BigInteger day, BigInteger hour) {
        final Function function = new Function(FUNC_TOTIMESTAMP, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint16(year), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint8(month), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint8(day), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint8(hour)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> getSecond(BigInteger timestamp) {
        final Function function = new Function(FUNC_GETSECOND, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(timestamp)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> toTimestamp(BigInteger year, BigInteger month, BigInteger day) {
        final Function function = new Function(FUNC_TOTIMESTAMP, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint16(year), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint8(month), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint8(day)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> toTimestamp(BigInteger year, BigInteger month, BigInteger day, BigInteger hour, BigInteger minute, BigInteger second) {
        final Function function = new Function(FUNC_TOTIMESTAMP, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint16(year), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint8(month), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint8(day), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint8(hour), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint8(minute), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint8(second)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> getYear(BigInteger timestamp) {
        final Function function = new Function(FUNC_GETYEAR, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(timestamp)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint16>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> getMonth(BigInteger timestamp) {
        final Function function = new Function(FUNC_GETMONTH, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(timestamp)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<Boolean> isLeapYear(BigInteger year) {
        final Function function = new Function(FUNC_ISLEAPYEAR, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint16(year)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<BigInteger> leapYearsBefore(BigInteger year) {
        final Function function = new Function(FUNC_LEAPYEARSBEFORE, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(year)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> getDaysInMonth(BigInteger month, BigInteger year) {
        final Function function = new Function(FUNC_GETDAYSINMONTH, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint8(month), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint16(year)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> getMinute(BigInteger timestamp) {
        final Function function = new Function(FUNC_GETMINUTE, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(timestamp)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static DateTime load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new DateTime(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static DateTime load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new DateTime(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static DateTime load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new DateTime(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static DateTime load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new DateTime(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<DateTime> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(DateTime.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<DateTime> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(DateTime.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<DateTime> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(DateTime.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<DateTime> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(DateTime.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
