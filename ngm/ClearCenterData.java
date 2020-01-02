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
import org.fisco.bcos.web3j.abi.datatypes.Function;
import org.fisco.bcos.web3j.abi.datatypes.Type;
import org.fisco.bcos.web3j.abi.datatypes.Utf8String;
import org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32;
import org.fisco.bcos.web3j.abi.datatypes.generated.Int256;
import org.fisco.bcos.web3j.abi.datatypes.generated.StaticArray3;
import org.fisco.bcos.web3j.abi.datatypes.generated.StaticArray5;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint256;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.RemoteCall;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tuples.generated.Tuple1;
import org.fisco.bcos.web3j.tuples.generated.Tuple2;
import org.fisco.bcos.web3j.tuples.generated.Tuple3;
import org.fisco.bcos.web3j.tuples.generated.Tuple7;
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
public class ClearCenterData extends Contract {
    public static String BINARY = "60806040523480156200001157600080fd5b5060405162001393380380620013938339810180604052810190808051820192919060200180518201929190505050818181600090805190602001906200005a9291906200007e565b508060019080519060200190620000739291906200007e565b50505050506200012d565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10620000c157805160ff1916838001178555620000f2565b82800160010185558215620000f2579182015b82811115620000f1578251825591602001919060010190620000d4565b5b50905062000101919062000105565b5090565b6200012a91905b80821115620001265760008160009055506001016200010c565b5090565b90565b611256806200013d6000396000f3006080604052600436106100f1576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806306fdde03146100f65780630afb21fa146101865780631166b54b146101b157806316023815146101f457806332c7f0ef1461023957806348870630146102a25780635f72811714610332578063679211951461037b5780637a2a66bb146103e85780639f40439514610480578063a79af2ce146104e5578063af33b5e014610614578063c4c2694614610685578063d3fb3013146106f6578063d613fb5714610731578063e1f726fe14610774578063e71485121461079f575b600080fd5b34801561010257600080fd5b5061010b610866565b6040518080602001828103825283818151815260200191508051906020019080838360005b8381101561014b578082015181840152602081019050610130565b50505050905090810190601f1680156101785780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561019257600080fd5b5061019b610904565b6040518082815260200191505060405180910390f35b3480156101bd57600080fd5b506101f2600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610911565b005b34801561020057600080fd5b506102236004803603810190808035600019169060200190929190505050610955565b6040518082815260200191505060405180910390f35b34801561024557600080fd5b506102646004803603810190808035906020019092919050505061097a565b6040518082600560200280838360005b8381101561028f578082015181840152602081019050610274565b5050505090500191505060405180910390f35b3480156102ae57600080fd5b506102b7610aa0565b6040518080602001828103825283818151815260200191508051906020019080838360005b838110156102f75780820151818401526020810190506102dc565b50505050905090810190601f1680156103245780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561033e57600080fd5b5061035d60048036038101908080359060200190929190505050610b3e565b60405180826000191660001916815260200191505060405180910390f35b34801561038757600080fd5b506103a660048036038101908080359060200190929190505050610b7d565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b3480156103f457600080fd5b5061041360048036038101908080359060200190929190505050610bd7565b6040518083600360200280838360005b8381101561043e578082015181840152602081019050610423565b5050505090500182600360200280838360005b8381101561046c578082015181840152602081019050610451565b505050509050019250505060405180910390f35b34801561048c57600080fd5b506104cf6004803603810190808035600019169060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610cb0565b6040518082815260200191505060405180910390f35b3480156104f157600080fd5b506104fa610da2565b6040518080602001806020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001838103835286818151815260200191508051906020019080838360005b83811015610570578082015181840152602081019050610555565b50505050905090810190601f16801561059d5780820380516001836020036101000a031916815260200191505b50838103825285818151815260200191508051906020019080838360005b838110156105d65780820151818401526020810190506105bb565b50505050905090810190601f1680156106035780820380516001836020036101000a031916815260200191505b509550505050505060405180910390f35b34801561062057600080fd5b506106436004803603810190808035600019169060200190929190505050610f10565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561069157600080fd5b506106b46004803603810190808035600019169060200190929190505050610f55565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561070257600080fd5b5061072f600480360381019080803560001916906020019092919080359060200190929190505050610f9a565b005b34801561073d57600080fd5b50610772600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610fbe565b005b34801561078057600080fd5b50610789611027565b6040518082815260200191505060405180910390f35b3480156107ab57600080fd5b50610850600480360381019080803590602001909291908035906020019092919080359060200190929190803590602001909291908035906020019092919080606001906003806020026040519081016040528092919082600360200280828437820191505050505091929192908060600190600380602002604051908101604052809291908260036020028082843782019150505050509192919290505050611034565b6040518082815260200191505060405180910390f35b60008054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156108fc5780601f106108d1576101008083540402835291602001916108fc565b820191906000526020600020905b8154815290600101906020018083116108df57829003601f168201915b505050505081565b6000600780549050905090565b80600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b6000600b60008360001916600019168152602001908152602001600020549050919050565b6109826110f1565b6000600c6000848152602001908152602001600020600001548160006005811015156109aa57fe5b0181905550600c6000848152602001908152602001600020600101548160016005811015156109d557fe5b0181905550600c600084815260200190815260200160002060020154816002600581101515610a0057fe5b0181905550600c600084815260200190815260200160002060030154816003600581101515610a2b57fe5b0181905550600c600084815260200190815260200160002060040154816004600581101515610a5657fe5b018190555080600580602002604051908101604052809291908260058015610a93576020028201915b815481526020019060010190808311610a7f575b5050505050915050919050565b60018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610b365780601f10610b0b57610100808354040283529160200191610b36565b820191906000526020600020905b815481529060010190602001808311610b1957829003601f168201915b505050505081565b600080600880549050905080831015610b7257600883815481101515610b6057fe5b90600052602060002001549150610b77565b600091505b50919050565b6000600780549050821015610bcd57600782815481101515610b9b57fe5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169050610bd2565b600090505b919050565b610bdf611114565b610be7611137565b610bef611114565b610bf7611137565b600c6000868152602001908152602001600020600501600380602002604051908101604052809291908260038015610c44576020028201915b815481526020019060010190808311610c30575b50505050509150600c6000868152602001908152602001600020600801600380602002604051908101604052809291908260038015610c9c576020028201915b81546000191681526020019060010190808311610c84575b505050505090508181935093505050915091565b60008060096000856000191660001916815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161415610d3e5760088390806001815401808255809150509060018203906000526020600020016000909192909190915090600019169055505b8160096000856000191660001916815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506000905092915050565b6060806000806001600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16828054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610e625780601f10610e3757610100808354040283529160200191610e62565b820191906000526020600020905b815481529060010190602001808311610e4557829003601f168201915b50505050509250818054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610efe5780601f10610ed357610100808354040283529160200191610efe565b820191906000526020600020905b815481529060010190602001808311610ee157829003601f168201915b50505050509150925092509250909192565b600060096000836000191660001916815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169050919050565b600060056000836000191660001916815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169050919050565b80600b60008460001916600019168152602001908152602001600020819055505050565b60078190806001815401808255809150509060018203906000526020600020016000909192909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505050565b6000600880549050905090565b600060e06040519081016040528089815260200188815260200187815260200186815260200185815260200184815260200183815250600c60008a8152602001908152602001600020600082015181600001556020820151816001015560408201518160020155606082015181600301556080820151816004015560a0820151816005019060036110c692919061115a565b5060c0820151816008019060036110de92919061119a565b5090505060009050979650505050505050565b60a060405190810160405280600590602082028038833980820191505090505090565b606060405190810160405280600390602082028038833980820191505090505090565b606060405190810160405280600390602082028038833980820191505090505090565b8260038101928215611189579160200282015b8281111561118857825182559160200191906001019061116d565b5b50905061119691906111e0565b5090565b82600381019282156111cf579160200282015b828111156111ce5782518290600019169055916020019190600101906111ad565b5b5090506111dc9190611205565b5090565b61120291905b808211156111fe5760008160009055506001016111e6565b5090565b90565b61122791905b8082111561122357600081600090555060010161120b565b5090565b905600a165627a7a72305820d958707c98b3fd5532aaca6cf858fb0b881c11dddb1a5ba511722314090d64b30029";

    public static final String ABI = "[{\"constant\":true,\"inputs\":[],\"name\":\"name\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getTransListSize\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"meta\",\"type\":\"address\"}],\"name\":\"setMetaAddress\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"reqId\",\"type\":\"bytes32\"}],\"name\":\"getCheckTagReq\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"currency\",\"type\":\"int256\"}],\"name\":\"getExchangeBochkRatePart1\",\"outputs\":[{\"name\":\"\",\"type\":\"int256[5]\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"abi\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"index\",\"type\":\"uint256\"}],\"name\":\"getOrgByIndex\",\"outputs\":[{\"name\":\"orgId\",\"type\":\"bytes32\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"offset\",\"type\":\"uint256\"}],\"name\":\"getTransByIndex\",\"outputs\":[{\"name\":\"addr\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"currency\",\"type\":\"int256\"}],\"name\":\"getExchangeBochkRatePart2\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256[3]\"},{\"name\":\"\",\"type\":\"bytes32[3]\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"orgId\",\"type\":\"bytes32\"},{\"name\":\"orgAddr\",\"type\":\"address\"}],\"name\":\"registerOrg\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getMeta\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"orgId\",\"type\":\"bytes32\"}],\"name\":\"getOrgAction\",\"outputs\":[{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"abBizNo\",\"type\":\"bytes32\"}],\"name\":\"getOrderAddress\",\"outputs\":[{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"reqId\",\"type\":\"bytes32\"},{\"name\":\"newCheckCode\",\"type\":\"int256\"}],\"name\":\"setCheckTagReq\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"orderAddr\",\"type\":\"address\"}],\"name\":\"addTrans\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getOrgListSize\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"currency\",\"type\":\"int256\"},{\"name\":\"fxRate\",\"type\":\"int256\"},{\"name\":\"refundFxRate\",\"type\":\"int256\"},{\"name\":\"exTimeStamp\",\"type\":\"int256\"},{\"name\":\"currencyUnit\",\"type\":\"int256\"},{\"name\":\"exDataArr\",\"type\":\"uint256[3]\"},{\"name\":\"exDataStr\",\"type\":\"bytes32[3]\"}],\"name\":\"setExchangeRate\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"inputs\":[{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"abi\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"}]";

    public static final TransactionDecoder transactionDecoder = new TransactionDecoder(ABI, BINARY);

    public static final String FUNC_NAME = "name";

    public static final String FUNC_GETTRANSLISTSIZE = "getTransListSize";

    public static final String FUNC_SETMETAADDRESS = "setMetaAddress";

    public static final String FUNC_GETCHECKTAGREQ = "getCheckTagReq";

    public static final String FUNC_GETEXCHANGEBOCHKRATEPART1 = "getExchangeBochkRatePart1";

    public static final String FUNC_ABI = "abi";

    public static final String FUNC_GETORGBYINDEX = "getOrgByIndex";

    public static final String FUNC_GETTRANSBYINDEX = "getTransByIndex";

    public static final String FUNC_GETEXCHANGEBOCHKRATEPART2 = "getExchangeBochkRatePart2";

    public static final String FUNC_REGISTERORG = "registerOrg";

    public static final String FUNC_GETMETA = "getMeta";

    public static final String FUNC_GETORGACTION = "getOrgAction";

    public static final String FUNC_GETORDERADDRESS = "getOrderAddress";

    public static final String FUNC_SETCHECKTAGREQ = "setCheckTagReq";

    public static final String FUNC_ADDTRANS = "addTrans";

    public static final String FUNC_GETORGLISTSIZE = "getOrgListSize";

    public static final String FUNC_SETEXCHANGERATE = "setExchangeRate";

    @Deprecated
    protected ClearCenterData(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ClearCenterData(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ClearCenterData(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ClearCenterData(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static TransactionDecoder getTransactionDecoder() {
        return transactionDecoder;
    }

    public RemoteCall<String> name() {
        final Function function = new Function(FUNC_NAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> getTransListSize() {
        final Function function = new Function(FUNC_GETTRANSLISTSIZE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
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

    public RemoteCall<BigInteger> getCheckTagReq(byte[] reqId) {
        final Function function = new Function(FUNC_GETCHECKTAGREQ, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32(reqId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<List> getExchangeBochkRatePart1(BigInteger currency) {
        final Function function = new Function(FUNC_GETEXCHANGEBOCHKRATEPART1, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(currency)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<StaticArray5<Int256>>() {}));
        return new RemoteCall<List>(
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteCall<String> abi() {
        final Function function = new Function(FUNC_ABI, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<byte[]> getOrgByIndex(BigInteger index) {
        final Function function = new Function(FUNC_GETORGBYINDEX, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<String> getTransByIndex(BigInteger offset) {
        final Function function = new Function(FUNC_GETTRANSBYINDEX, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(offset)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<Tuple2<List<BigInteger>, List<byte[]>>> getExchangeBochkRatePart2(BigInteger currency) {
        final Function function = new Function(FUNC_GETEXCHANGEBOCHKRATEPART2, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(currency)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<StaticArray3<Uint256>>() {}, new TypeReference<StaticArray3<Bytes32>>() {}));
        return new RemoteCall<Tuple2<List<BigInteger>, List<byte[]>>>(
                new Callable<Tuple2<List<BigInteger>, List<byte[]>>>() {
                    @Override
                    public Tuple2<List<BigInteger>, List<byte[]>> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<List<BigInteger>, List<byte[]>>(
                                convertToNative((List<Uint256>) results.get(0).getValue()), 
                                convertToNative((List<Bytes32>) results.get(1).getValue()));
                    }
                });
    }

    public RemoteCall<TransactionReceipt> registerOrg(byte[] orgId, String orgAddr) {
        final Function function = new Function(
                FUNC_REGISTERORG, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32(orgId), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(orgAddr)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void registerOrg(byte[] orgId, String orgAddr, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_REGISTERORG, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32(orgId), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(orgAddr)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String registerOrgSeq(byte[] orgId, String orgAddr) {
        final Function function = new Function(
                FUNC_REGISTERORG, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32(orgId), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(orgAddr)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<byte[], String> getRegisterOrgInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_REGISTERORG, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple2<byte[], String>(

                (byte[]) results.get(0).getValue(), 
                (String) results.get(1).getValue()
                );
    }

    public Tuple1<BigInteger> getRegisterOrgOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_REGISTERORG, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
                );
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

    public RemoteCall<String> getOrgAction(byte[] orgId) {
        final Function function = new Function(FUNC_GETORGACTION, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32(orgId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> getOrderAddress(byte[] abBizNo) {
        final Function function = new Function(FUNC_GETORDERADDRESS, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32(abBizNo)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> setCheckTagReq(byte[] reqId, BigInteger newCheckCode) {
        final Function function = new Function(
                FUNC_SETCHECKTAGREQ, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32(reqId), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(newCheckCode)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setCheckTagReq(byte[] reqId, BigInteger newCheckCode, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETCHECKTAGREQ, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32(reqId), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(newCheckCode)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setCheckTagReqSeq(byte[] reqId, BigInteger newCheckCode) {
        final Function function = new Function(
                FUNC_SETCHECKTAGREQ, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32(reqId), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(newCheckCode)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<byte[], BigInteger> getSetCheckTagReqInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETCHECKTAGREQ, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Int256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple2<byte[], BigInteger>(

                (byte[]) results.get(0).getValue(), 
                (BigInteger) results.get(1).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> addTrans(String orderAddr) {
        final Function function = new Function(
                FUNC_ADDTRANS, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(orderAddr)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void addTrans(String orderAddr, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_ADDTRANS, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(orderAddr)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String addTransSeq(String orderAddr) {
        final Function function = new Function(
                FUNC_ADDTRANS, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(orderAddr)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<String> getAddTransInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_ADDTRANS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<String>(

                (String) results.get(0).getValue()
                );
    }

    public RemoteCall<BigInteger> getOrgListSize() {
        final Function function = new Function(FUNC_GETORGLISTSIZE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> setExchangeRate(BigInteger currency, BigInteger fxRate, BigInteger refundFxRate, BigInteger exTimeStamp, BigInteger currencyUnit, List<BigInteger> exDataArr, List<byte[]> exDataStr) {
        final Function function = new Function(
                FUNC_SETEXCHANGERATE, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(currency), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(fxRate), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(refundFxRate), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(exTimeStamp), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(currencyUnit), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.StaticArray3<org.fisco.bcos.web3j.abi.datatypes.generated.Uint256>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(exDataArr, org.fisco.bcos.web3j.abi.datatypes.generated.Uint256.class)), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.StaticArray3<org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(exDataStr, org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setExchangeRate(BigInteger currency, BigInteger fxRate, BigInteger refundFxRate, BigInteger exTimeStamp, BigInteger currencyUnit, List<BigInteger> exDataArr, List<byte[]> exDataStr, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETEXCHANGERATE, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(currency), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(fxRate), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(refundFxRate), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(exTimeStamp), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(currencyUnit), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.StaticArray3<org.fisco.bcos.web3j.abi.datatypes.generated.Uint256>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(exDataArr, org.fisco.bcos.web3j.abi.datatypes.generated.Uint256.class)), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.StaticArray3<org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(exDataStr, org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32.class))), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setExchangeRateSeq(BigInteger currency, BigInteger fxRate, BigInteger refundFxRate, BigInteger exTimeStamp, BigInteger currencyUnit, List<BigInteger> exDataArr, List<byte[]> exDataStr) {
        final Function function = new Function(
                FUNC_SETEXCHANGERATE, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(currency), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(fxRate), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(refundFxRate), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(exTimeStamp), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(currencyUnit), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.StaticArray3<org.fisco.bcos.web3j.abi.datatypes.generated.Uint256>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(exDataArr, org.fisco.bcos.web3j.abi.datatypes.generated.Uint256.class)), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.StaticArray3<org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(exDataStr, org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32.class))), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple7<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, List<BigInteger>, List<byte[]>> getSetExchangeRateInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETEXCHANGERATE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}, new TypeReference<Int256>() {}, new TypeReference<Int256>() {}, new TypeReference<Int256>() {}, new TypeReference<Int256>() {}, new TypeReference<StaticArray3<Uint256>>() {}, new TypeReference<StaticArray3<Bytes32>>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple7<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, List<BigInteger>, List<byte[]>>(

                (BigInteger) results.get(0).getValue(), 
                (BigInteger) results.get(1).getValue(), 
                (BigInteger) results.get(2).getValue(), 
                (BigInteger) results.get(3).getValue(), 
                (BigInteger) results.get(4).getValue(), 
                convertToNative((List<Uint256>) results.get(5).getValue()), 
                convertToNative((List<Bytes32>) results.get(6).getValue())
                );
    }

    public Tuple1<BigInteger> getSetExchangeRateOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_SETEXCHANGERATE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
                );
    }

    @Deprecated
    public static ClearCenterData load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ClearCenterData(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ClearCenterData load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ClearCenterData(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ClearCenterData load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ClearCenterData(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ClearCenterData load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ClearCenterData(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ClearCenterData> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String name, String abi) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(name), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(abi)));
        return deployRemoteCall(ClearCenterData.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<ClearCenterData> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String name, String abi) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(name), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(abi)));
        return deployRemoteCall(ClearCenterData.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ClearCenterData> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String name, String abi) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(name), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(abi)));
        return deployRemoteCall(ClearCenterData.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ClearCenterData> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String name, String abi) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(name), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(abi)));
        return deployRemoteCall(ClearCenterData.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
