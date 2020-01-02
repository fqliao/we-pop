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
    public static String BINARY = "608060405234801561001057600080fd5b50610d9a806100206000396000f3006080604052600436106100d0576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806317e4ea20146100d55780632741ae1a1461013457806360ddbaaa1461018c578063735055ed146101d55780637369c51a1461021c57806382a1518d146102655780638999c20b146102ac5780639042c179146103325780639b4a1c8d14610379578063aa7fbee2146103e5578063c73a8d831461042c578063c80a1f131461046d578063d2c32a6b146104e6578063e31246441461052d575b600080fd5b3480156100e157600080fd5b5061011e600480360381019080803561ffff169060200190929190803560ff169060200190929190803560ff169060200190929190505050610574565b6040518082815260200191505060405180910390f35b34801561014057600080fd5b50610170600480360381019080803560ff169060200190929190803561ffff16906020019092919050505061058f565b604051808260ff1660ff16815260200191505060405180910390f35b34801561019857600080fd5b506101bb600480360381019080803561ffff16906020019092919050505061065b565b604051808215151515815260200191505060405180910390f35b3480156101e157600080fd5b50610200600480360381019080803590602001909291905050506106dc565b604051808260ff1660ff16815260200191505060405180910390f35b34801561022857600080fd5b5061024760048036038101908080359060200190929190505050610703565b604051808261ffff1661ffff16815260200191505060405180910390f35b34801561027157600080fd5b50610290600480360381019080803590602001909291905050506107ae565b604051808260ff1660ff16815260200191505060405180910390f35b3480156102b857600080fd5b5061031c600480360381019080803561ffff169060200190929190803560ff169060200190929190803560ff169060200190929190803560ff169060200190929190803560ff169060200190929190803560ff1690602001909291905050506107c4565b6040518082815260200191505060405180910390f35b34801561033e57600080fd5b5061035d60048036038101908080359060200190929190505050610a6b565b604051808260ff1660ff16815260200191505060405180910390f35b34801561038557600080fd5b506103cf600480360381019080803561ffff169060200190929190803560ff169060200190929190803560ff169060200190929190803560ff169060200190929190505050610a81565b6040518082815260200191505060405180910390f35b3480156103f157600080fd5b5061041060048036038101908080359060200190929190505050610a9c565b604051808260ff1660ff16815260200191505060405180910390f35b34801561043857600080fd5b5061045760048036038101908080359060200190929190505050610ac9565b6040518082815260200191505060405180910390f35b34801561047957600080fd5b506104d0600480360381019080803561ffff169060200190929190803560ff169060200190929190803560ff169060200190929190803560ff169060200190929190803560ff169060200190929190505050610b02565b6040518082815260200191505060405180910390f35b3480156104f257600080fd5b5061051160048036038101908080359060200190929190505050610b1e565b604051808260ff1660ff16815260200191505060405180910390f35b34801561053957600080fd5b5061055860048036038101908080359060200190929190505050610b34565b604051808260ff1660ff16815260200191505060405180910390f35b600061058684848460008060006107c4565b90509392505050565b600060018360ff1614806105a6575060038360ff16145b806105b4575060058360ff16145b806105c2575060078360ff16145b806105d0575060088360ff16145b806105de5750600a8360ff16145b806105ec5750600c8360ff16145b156105fa57601f9050610655565b60048360ff16148061060f575060068360ff16145b8061061d575060098360ff16145b8061062b5750600b8360ff16145b1561063957601e9050610655565b6106428261065b565b1561065057601d9050610655565b601c90505b92915050565b60008060048361ffff1681151561066e57fe5b0661ffff1614151561068357600090506106d7565b600060648361ffff1681151561069557fe5b0661ffff161415156106aa57600190506106d7565b60006101908361ffff168115156106bd57fe5b0661ffff161415156106d257600090506106d7565b600190505b919050565b60006007600462015180848115156106f057fe5b04018115156106fb57fe5b069050919050565b600080600080600092506301e133808581151561071c57fe5b046107b261ffff160191506107366107b261ffff16610ac9565b6107438361ffff16610ac9565b039050806301e285000283019250806107b2830361ffff16036301e1338002830192505b848311156107a35761077b6001830361065b565b1561078e576301e2850083039250610798565b6301e13380830392505b600182039150610767565b819350505050919050565b60006107b982610b55565b604001519050919050565b6000806107cf610cf6565b6107b291505b8861ffff168261ffff161015610818576107ee8261065b565b15610801576301e285008301925061080b565b6301e13380830192505b81806001019250506107d5565b601f816000600c8110151561082957fe5b602002019060ff16908160ff16815250506108438961065b565b1561086f57601d816001600c8110151561085957fe5b602002019060ff16908160ff1681525050610892565b601c816001600c8110151561088057fe5b602002019060ff16908160ff16815250505b601f816002600c811015156108a357fe5b602002019060ff16908160ff1681525050601e816003600c811015156108c557fe5b602002019060ff16908160ff1681525050601f816004600c811015156108e757fe5b602002019060ff16908160ff1681525050601e816005600c8110151561090957fe5b602002019060ff16908160ff1681525050601f816006600c8110151561092b57fe5b602002019060ff16908160ff1681525050601f816007600c8110151561094d57fe5b602002019060ff16908160ff1681525050601e816008600c8110151561096f57fe5b602002019060ff16908160ff1681525050601f816009600c8110151561099157fe5b602002019060ff16908160ff1681525050601e81600a600c811015156109b357fe5b602002019060ff16908160ff1681525050601f81600b600c811015156109d557fe5b602002019060ff16908160ff1681525050600191505b8760ff168261ffff161015610a2d57806001830361ffff16600c81101515610a0f57fe5b602002015160ff1662015180028301925081806001019250506109eb565b6001870360ff166201518002830192508560ff16610e1002830192508460ff16603c02830192508360ff168301925082925050509695505050505050565b6000603c82811515610a7957fe5b069050919050565b6000610a92858585856000806107c4565b9050949350505050565b60006018603c8084811515610aad57fe5b04811515610ab757fe5b04811515610ac157fe5b069050919050565b600060018203915061019082811515610ade57fe5b04606483811515610aeb57fe5b04600484811515610af857fe5b0403019050919050565b6000610b13868686868660006107c4565b905095945050505050565b6000610b2982610b55565b602001519050919050565b6000603c8083811515610b4357fe5b04811515610b4d57fe5b069050919050565b610b5d610d1a565b60008060008060009350610b7086610703565b856000019061ffff16908161ffff1681525050610b926107b261ffff16610ac9565b610ba3866000015161ffff16610ac9565b039250826301e285000284019350826107b286600001510361ffff16036301e133800284019350600191505b600c8260ff16111515610c2757610bea82866000015161058f565b60ff1662015180029050858482011115610c155781856020019060ff16908160ff1681525050610c27565b80840193508180600101925050610bcf565b600191505b610c3e8560200151866000015161058f565b60ff168260ff16111515610c8557858462015180011115610c705781856040019060ff16908160ff1681525050610c85565b62015180840193508180600101925050610c2c565b610c8e86610a9c565b856060019060ff16908160ff1681525050610ca886610b34565b856080019060ff16908160ff1681525050610cc286610a6b565b8560a0019060ff16908160ff1681525050610cdc866106dc565b8560c0019060ff16908160ff168152505050505050919050565b61018060405190810160405280600c90602082028038833980820191505090505090565b60e060405190810160405280600061ffff168152602001600060ff168152602001600060ff168152602001600060ff168152602001600060ff168152602001600060ff168152602001600060ff16815250905600a165627a7a72305820d8f09b44e01a3e6f82ad6996c9b13865bba663fb3741ff63e67ff8256af5374b0029";

    public static final String ABI = "[{\"constant\":true,\"inputs\":[{\"name\":\"year\",\"type\":\"uint16\"},{\"name\":\"month\",\"type\":\"uint8\"},{\"name\":\"day\",\"type\":\"uint8\"}],\"name\":\"toTimestamp\",\"outputs\":[{\"name\":\"timestamp\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"month\",\"type\":\"uint8\"},{\"name\":\"year\",\"type\":\"uint16\"}],\"name\":\"getDaysInMonth\",\"outputs\":[{\"name\":\"\",\"type\":\"uint8\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"year\",\"type\":\"uint16\"}],\"name\":\"isLeapYear\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"timestamp\",\"type\":\"uint256\"}],\"name\":\"getWeekday\",\"outputs\":[{\"name\":\"\",\"type\":\"uint8\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"timestamp\",\"type\":\"uint256\"}],\"name\":\"getYear\",\"outputs\":[{\"name\":\"\",\"type\":\"uint16\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"timestamp\",\"type\":\"uint256\"}],\"name\":\"getDay\",\"outputs\":[{\"name\":\"\",\"type\":\"uint8\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"year\",\"type\":\"uint16\"},{\"name\":\"month\",\"type\":\"uint8\"},{\"name\":\"day\",\"type\":\"uint8\"},{\"name\":\"hour\",\"type\":\"uint8\"},{\"name\":\"minute\",\"type\":\"uint8\"},{\"name\":\"second\",\"type\":\"uint8\"}],\"name\":\"toTimestamp\",\"outputs\":[{\"name\":\"timestamp\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"timestamp\",\"type\":\"uint256\"}],\"name\":\"getSecond\",\"outputs\":[{\"name\":\"\",\"type\":\"uint8\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"year\",\"type\":\"uint16\"},{\"name\":\"month\",\"type\":\"uint8\"},{\"name\":\"day\",\"type\":\"uint8\"},{\"name\":\"hour\",\"type\":\"uint8\"}],\"name\":\"toTimestamp\",\"outputs\":[{\"name\":\"timestamp\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"timestamp\",\"type\":\"uint256\"}],\"name\":\"getHour\",\"outputs\":[{\"name\":\"\",\"type\":\"uint8\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"year\",\"type\":\"uint256\"}],\"name\":\"leapYearsBefore\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"year\",\"type\":\"uint16\"},{\"name\":\"month\",\"type\":\"uint8\"},{\"name\":\"day\",\"type\":\"uint8\"},{\"name\":\"hour\",\"type\":\"uint8\"},{\"name\":\"minute\",\"type\":\"uint8\"}],\"name\":\"toTimestamp\",\"outputs\":[{\"name\":\"timestamp\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"timestamp\",\"type\":\"uint256\"}],\"name\":\"getMonth\",\"outputs\":[{\"name\":\"\",\"type\":\"uint8\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"timestamp\",\"type\":\"uint256\"}],\"name\":\"getMinute\",\"outputs\":[{\"name\":\"\",\"type\":\"uint8\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"}]";

    public static final TransactionDecoder transactionDecoder = new TransactionDecoder(ABI, BINARY);

    public static final String FUNC_TOTIMESTAMP = "toTimestamp";

    public static final String FUNC_GETDAYSINMONTH = "getDaysInMonth";

    public static final String FUNC_ISLEAPYEAR = "isLeapYear";

    public static final String FUNC_GETWEEKDAY = "getWeekday";

    public static final String FUNC_GETYEAR = "getYear";

    public static final String FUNC_GETDAY = "getDay";

    public static final String FUNC_GETSECOND = "getSecond";

    public static final String FUNC_GETHOUR = "getHour";

    public static final String FUNC_LEAPYEARSBEFORE = "leapYearsBefore";

    public static final String FUNC_GETMONTH = "getMonth";

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

    public RemoteCall<BigInteger> toTimestamp(BigInteger year, BigInteger month, BigInteger day) {
        final Function function = new Function(FUNC_TOTIMESTAMP, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint16(year), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint8(month), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint8(day)), 
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

    public RemoteCall<Boolean> isLeapYear(BigInteger year) {
        final Function function = new Function(FUNC_ISLEAPYEAR, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint16(year)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<BigInteger> getWeekday(BigInteger timestamp) {
        final Function function = new Function(FUNC_GETWEEKDAY, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(timestamp)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> getYear(BigInteger timestamp) {
        final Function function = new Function(FUNC_GETYEAR, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(timestamp)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint16>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> getDay(BigInteger timestamp) {
        final Function function = new Function(FUNC_GETDAY, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(timestamp)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
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

    public RemoteCall<BigInteger> getSecond(BigInteger timestamp) {
        final Function function = new Function(FUNC_GETSECOND, 
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

    public RemoteCall<BigInteger> getHour(BigInteger timestamp) {
        final Function function = new Function(FUNC_GETHOUR, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(timestamp)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> leapYearsBefore(BigInteger year) {
        final Function function = new Function(FUNC_LEAPYEARSBEFORE, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(year)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
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

    public RemoteCall<BigInteger> getMonth(BigInteger timestamp) {
        final Function function = new Function(FUNC_GETMONTH, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(timestamp)), 
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
