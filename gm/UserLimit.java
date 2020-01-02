package cn.webank.blockchain.contracts.web3j;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.fisco.bcos.channel.client.TransactionSucCallback;
import org.fisco.bcos.web3j.abi.FunctionEncoder;
import org.fisco.bcos.web3j.abi.FunctionReturnDecoder;
import org.fisco.bcos.web3j.abi.TypeReference;
import org.fisco.bcos.web3j.abi.datatypes.Address;
import org.fisco.bcos.web3j.abi.datatypes.Bool;
import org.fisco.bcos.web3j.abi.datatypes.Function;
import org.fisco.bcos.web3j.abi.datatypes.Type;
import org.fisco.bcos.web3j.abi.datatypes.Utf8String;
import org.fisco.bcos.web3j.abi.datatypes.generated.Int256;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint256;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.RemoteCall;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tuples.generated.Tuple1;
import org.fisco.bcos.web3j.tuples.generated.Tuple2;
import org.fisco.bcos.web3j.tuples.generated.Tuple3;
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
public class UserLimit extends Contract {
    public static String BINARY = "60806040523480156200001157600080fd5b50604051620016e6380380620016e68339810180604052810190808051820192919060200180518201929190602001805190602001909291908051906020019092919050505083838160009080519060200190620000719291906200041a565b5080600190805190602001906200008a9291906200041a565b50505081600860006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555080600960006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506200012862000156640100000000026401000000009004565b60056000600360008491905055839190505550506000600481905550600060068190555050505050620004c9565b60008060008060008060006103e880428115156200017057fe5b0642038115156200017d57fe5b049450600960009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16637369c51a866040518263ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180828152602001915050602060405180830381600087803b1580156200021257600080fd5b505af115801562000227573d6000803e3d6000fd5b505050506040513d60208110156200023e57600080fd5b810190808051906020019092919050505061ffff169350600960009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663d2c32a6b866040518263ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180828152602001915050602060405180830381600087803b158015620002e757600080fd5b505af1158015620002fc573d6000803e3d6000fd5b505050506040513d60208110156200031357600080fd5b810190808051906020019092919050505060ff169250600960009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166382a1518d866040518263ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180828152602001915050602060405180830381600087803b158015620003bb57600080fd5b505af1158015620003d0573d6000803e3d6000fd5b505050506040513d6020811015620003e757600080fd5b810190808051906020019092919050505060ff169150816064840261271086020101905083819650965050505050509091565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106200045d57805160ff19168380011785556200048e565b828001600101855582156200048e579182015b828111156200048d57825182559160200191906001019062000470565b5b5090506200049d9190620004a1565b5090565b620004c691905b80821115620004c2576000816000905550600101620004a8565b5090565b90565b61120d80620004d96000396000f3006080604052600436106100da576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806267c5f1146100df5780630e698a0014610122578063234f70a51461014d578063330d4fbe146101a457806342d8311d146101e75780636e19d2651461023e5780637ac62f98146102695780637b4832da1461029b57806395a278fe146102de578063a8546acc14610309578063b11b688314610360578063b40bfca9146103f0578063ca1c8a8b14610480578063d8fe5476146104ab578063ec9c8913146105da575b600080fd5b3480156100eb57600080fd5b50610120600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610635565b005b34801561012e57600080fd5b50610137610679565b6040518082815260200191505060405180910390f35b34801561015957600080fd5b5061016261067f565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b3480156101b057600080fd5b506101e5600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506106a5565b005b3480156101f357600080fd5b506101fc6106e9565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561024a57600080fd5b5061025361070f565b6040518082815260200191505060405180910390f35b34801561027557600080fd5b5061027e610715565b604051808381526020018281526020019250505060405180910390f35b3480156102a757600080fd5b506102dc600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506109ce565b005b3480156102ea57600080fd5b506102f3610a12565b6040518082815260200191505060405180910390f35b34801561031557600080fd5b5061031e610a18565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561036c57600080fd5b50610375610a3e565b6040518080602001828103825283818151815260200191508051906020019080838360005b838110156103b557808201518184015260208101905061039a565b50505050905090810190601f1680156103e25780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b3480156103fc57600080fd5b50610405610adc565b6040518080602001828103825283818151815260200191508051906020019080838360005b8381101561044557808201518184015260208101905061042a565b50505050905090810190601f1680156104725780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561048c57600080fd5b50610495610b7a565b6040518082815260200191505060405180910390f35b3480156104b757600080fd5b506104c0610b80565b6040518080602001806020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001838103835286818151815260200191508051906020019080838360005b8381101561053657808201518184015260208101905061051b565b50505050905090810190601f1680156105635780820380516001836020036101000a031916815260200191505b50838103825285818151815260200191508051906020019080838360005b8381101561059c578082015181840152602081019050610581565b50505050905090810190601f1680156105c95780820380516001836020036101000a031916815260200191505b509550505050505060405180910390f35b3480156105e657600080fd5b5061061b600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610cee565b604051808215151515815260200191505060405180910390f35b80600860006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b60045481565b600760009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b80600760006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b600860009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b60055481565b60008060008060008060006103e8804281151561072e57fe5b06420381151561073a57fe5b049450600960009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16637369c51a866040518263ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180828152602001915050602060405180830381600087803b1580156107ce57600080fd5b505af11580156107e2573d6000803e3d6000fd5b505050506040513d60208110156107f857600080fd5b810190808051906020019092919050505061ffff169350600960009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663d2c32a6b866040518263ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180828152602001915050602060405180830381600087803b1580156108a057600080fd5b505af11580156108b4573d6000803e3d6000fd5b505050506040513d60208110156108ca57600080fd5b810190808051906020019092919050505060ff169250600960009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166382a1518d866040518263ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180828152602001915050602060405180830381600087803b15801561097157600080fd5b505af1158015610985573d6000803e3d6000fd5b505050506040513d602081101561099b57600080fd5b810190808051906020019092919050505060ff169150816064840261271086020101905083819650965050505050509091565b80600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b60035481565b600960009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b60008054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610ad45780601f10610aa957610100808354040283529160200191610ad4565b820191906000526020600020905b815481529060010190602001808311610ab757829003601f168201915b505050505081565b60018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610b725780601f10610b4757610100808354040283529160200191610b72565b820191906000526020600020905b815481529060010190602001808311610b5557829003601f168201915b505050505081565b60065481565b6060806000806001600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16828054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610c405780601f10610c1557610100808354040283529160200191610c40565b820191906000526020600020905b815481529060010190602001808311610c2357829003601f168201915b50505050509250818054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610cdc5780601f10610cb157610100808354040283529160200191610cdc565b820191906000526020600020905b815481529060010190602001808311610cbf57829003601f168201915b50505050509150925092509250909192565b6000806000806000808673ffffffffffffffffffffffffffffffffffffffff166358c6abe16040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b158015610d5b57600080fd5b505af1158015610d6f573d6000803e3d6000fd5b505050506040513d6020811015610d8557600080fd5b810190808051906020019092919050505094508673ffffffffffffffffffffffffffffffffffffffff16633d30969e6040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b158015610dfc57600080fd5b505af1158015610e10573d6000803e3d6000fd5b505050506040513d6020811015610e2657600080fd5b810190808051906020019092919050505093508673ffffffffffffffffffffffffffffffffffffffff1663c16dc24f6040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b158015610e9d57600080fd5b505af1158015610eb1573d6000803e3d6000fd5b505050506040513d6020811015610ec757600080fd5b81019080805190602001909291905050509250600d84148015610eeb575060018314155b156111d257600860009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16631c81092f6040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b158015610f7657600080fd5b505af1158015610f8a573d6000803e3d6000fd5b505050506040513d6020811015610fa057600080fd5b8101908080519060200190929190505050851315610fc157600095506111d7565b610fc9610715565b809250819350505060055482141515610fec578160058190555060006006819055505b60035481141515611007578060038190555060006004819055505b600860009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663b4bf73966040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b15801561108d57600080fd5b505af11580156110a1573d6000803e3d6000fd5b505050506040513d60208110156110b757600080fd5b8101908080519060200190929190505050856004540113156110dc57600095506111d7565b600860009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16637bdf7e9a6040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b15801561116257600080fd5b505af1158015611176573d6000803e3d6000fd5b505050506040513d602081101561118c57600080fd5b8101908080519060200190929190505050856006540113156111b157600095506111d7565b84600460008282540192505081905550846006600082825401925050819055505b600195505b50505050509190505600a165627a7a723058206ff74281b536a21778aa3f6b1d61bd6829791f32a2d9405ae942baaf2de999140029";

    public static final String ABI = "[{\"constant\":false,\"inputs\":[{\"name\":\"_poplimit\",\"type\":\"address\"}],\"name\":\"setPopLimit\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"todayTotal\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"userInfo\",\"outputs\":[{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_userinfo\",\"type\":\"address\"}],\"name\":\"setUserInfo\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"popLimit\",\"outputs\":[{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"currentYear\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getYearAndDate\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"},{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"meta\",\"type\":\"address\"}],\"name\":\"setMetaAddress\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"currentToday\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"dateTime\",\"outputs\":[{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"name\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"abi\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"yearTotal\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getMeta\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"order\",\"type\":\"address\"}],\"name\":\"limitCheck\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"inputs\":[{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"abi\",\"type\":\"string\"},{\"name\":\"_poplimit\",\"type\":\"address\"},{\"name\":\"_datetime\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"}]";

    public static final TransactionDecoder transactionDecoder = new TransactionDecoder(ABI, BINARY);

    public static final String FUNC_SETPOPLIMIT = "setPopLimit";

    public static final String FUNC_TODAYTOTAL = "todayTotal";

    public static final String FUNC_USERINFO = "userInfo";

    public static final String FUNC_SETUSERINFO = "setUserInfo";

    public static final String FUNC_POPLIMIT = "popLimit";

    public static final String FUNC_CURRENTYEAR = "currentYear";

    public static final String FUNC_GETYEARANDDATE = "getYearAndDate";

    public static final String FUNC_SETMETAADDRESS = "setMetaAddress";

    public static final String FUNC_CURRENTTODAY = "currentToday";

    public static final String FUNC_DATETIME = "dateTime";

    public static final String FUNC_NAME = "name";

    public static final String FUNC_ABI = "abi";

    public static final String FUNC_YEARTOTAL = "yearTotal";

    public static final String FUNC_GETMETA = "getMeta";

    public static final String FUNC_LIMITCHECK = "limitCheck";

    @Deprecated
    protected UserLimit(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected UserLimit(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected UserLimit(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected UserLimit(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static TransactionDecoder getTransactionDecoder() {
        return transactionDecoder;
    }

    public RemoteCall<TransactionReceipt> setPopLimit(String _poplimit) {
        final Function function = new Function(
                FUNC_SETPOPLIMIT, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(_poplimit)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setPopLimit(String _poplimit, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETPOPLIMIT, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(_poplimit)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setPopLimitSeq(String _poplimit) {
        final Function function = new Function(
                FUNC_SETPOPLIMIT, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(_poplimit)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<String> getSetPopLimitInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETPOPLIMIT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<String>(

                (String) results.get(0).getValue()
                );
    }

    public RemoteCall<BigInteger> todayTotal() {
        final Function function = new Function(FUNC_TODAYTOTAL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> userInfo() {
        final Function function = new Function(FUNC_USERINFO, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> setUserInfo(String _userinfo) {
        final Function function = new Function(
                FUNC_SETUSERINFO, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(_userinfo)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setUserInfo(String _userinfo, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETUSERINFO, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(_userinfo)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setUserInfoSeq(String _userinfo) {
        final Function function = new Function(
                FUNC_SETUSERINFO, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(_userinfo)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<String> getSetUserInfoInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETUSERINFO, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<String>(

                (String) results.get(0).getValue()
                );
    }

    public RemoteCall<String> popLimit() {
        final Function function = new Function(FUNC_POPLIMIT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> currentYear() {
        final Function function = new Function(FUNC_CURRENTYEAR, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<Tuple2<BigInteger, BigInteger>> getYearAndDate() {
        final Function function = new Function(FUNC_GETYEARANDDATE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple2<BigInteger, BigInteger>>(
                new Callable<Tuple2<BigInteger, BigInteger>>() {
                    @Override
                    public Tuple2<BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<BigInteger, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue());
                    }
                });
    }

    public RemoteCall<TransactionReceipt> setMetaAddress(String meta) {
        final Function function = new Function(
                FUNC_SETMETAADDRESS, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(meta)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setMetaAddress(String meta, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETMETAADDRESS, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(meta)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setMetaAddressSeq(String meta) {
        final Function function = new Function(
                FUNC_SETMETAADDRESS, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(meta)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<String> getSetMetaAddressInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETMETAADDRESS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<String>(

                (String) results.get(0).getValue()
                );
    }

    public RemoteCall<BigInteger> currentToday() {
        final Function function = new Function(FUNC_CURRENTTODAY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> dateTime() {
        final Function function = new Function(FUNC_DATETIME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> name() {
        final Function function = new Function(FUNC_NAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> abi() {
        final Function function = new Function(FUNC_ABI, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> yearTotal() {
        final Function function = new Function(FUNC_YEARTOTAL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<Tuple3<String, String, String>> getMeta() {
        final Function function = new Function(FUNC_GETMETA, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Address>() {}));
        return new RemoteCall<Tuple3<String, String, String>>(
                new Callable<Tuple3<String, String, String>>() {
                    @Override
                    public Tuple3<String, String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<String, String, String>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue());
                    }
                });
    }

    public RemoteCall<TransactionReceipt> limitCheck(String order) {
        final Function function = new Function(
                FUNC_LIMITCHECK, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(order)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void limitCheck(String order, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_LIMITCHECK, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(order)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String limitCheckSeq(String order) {
        final Function function = new Function(
                FUNC_LIMITCHECK, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(order)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<String> getLimitCheckInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_LIMITCHECK, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<String>(

                (String) results.get(0).getValue()
                );
    }

    public Tuple1<Boolean> getLimitCheckOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_LIMITCHECK, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<Boolean>(

                (Boolean) results.get(0).getValue()
                );
    }

    @Deprecated
    public static UserLimit load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new UserLimit(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static UserLimit load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new UserLimit(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static UserLimit load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new UserLimit(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static UserLimit load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new UserLimit(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<UserLimit> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String name, String abi, String _poplimit, String _datetime) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(name), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(abi), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(_poplimit), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(_datetime)));
        return deployRemoteCall(UserLimit.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<UserLimit> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String name, String abi, String _poplimit, String _datetime) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(name), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(abi), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(_poplimit), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(_datetime)));
        return deployRemoteCall(UserLimit.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<UserLimit> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String name, String abi, String _poplimit, String _datetime) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(name), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(abi), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(_poplimit), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(_datetime)));
        return deployRemoteCall(UserLimit.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<UserLimit> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String name, String abi, String _poplimit, String _datetime) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(name), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(abi), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(_poplimit), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(_datetime)));
        return deployRemoteCall(UserLimit.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
