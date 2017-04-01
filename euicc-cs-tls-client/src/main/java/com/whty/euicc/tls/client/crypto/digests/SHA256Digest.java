package com.whty.euicc.tls.client.crypto.digests;

public class SHA256Digest extends GeneralDigest
{
  private static final int DIGEST_LENGTH = 32;
  

  private int H1;
  
  private int H2;
  
  private int H3;
  
  private int H4;
  
  private int H5;
  
  private int H6;
  
  private int H7;
  
  private int H8;
  
  private int[] X = new int[64];
  

  private int xOff;
  

  public SHA256Digest()
  {
    reset();
  }
  




  public SHA256Digest(SHA256Digest t)
  {
    super(t);
    
    H1 = H1;
    H2 = H2;
    H3 = H3;
    H4 = H4;
    H5 = H5;
    H6 = H6;
    H7 = H7;
    H8 = H8;
    
    System.arraycopy(X, 0, X, 0, X.length);
    xOff = xOff;
  }
  
  public String getAlgorithmName()
  {
    return "SHA-256";
  }
  
  public int getDigestSize()
  {
    return 32;
  }
  


  protected void processWord(byte[] in, int inOff)
  {
    X[(xOff++)] = 
      ((in[inOff] & 0xFF) << 24 | (in[(inOff + 1)] & 0xFF) << 16 | (in[(inOff + 2)] & 0xFF) << 8 | in[(inOff + 3)] & 0xFF);
    
    if (xOff == 16)
    {
      processBlock();
    }
  }
  



  private void unpackWord(int word, byte[] out, int outOff)
  {
    out[outOff] = ((byte)(word >>> 24));
    out[(outOff + 1)] = ((byte)(word >>> 16));
    out[(outOff + 2)] = ((byte)(word >>> 8));
    out[(outOff + 3)] = ((byte)word);
  }
  

  protected void processLength(long bitLength)
  {
    if (xOff > 14)
    {
      processBlock();
    }
    
    X[14] = ((int)(bitLength >>> 32));
    X[15] = ((int)(bitLength & 0xFFFFFFFFFFFFFFFFl));
  }
  


  public int doFinal(byte[] out, int outOff)
  {
    finish();
    
    unpackWord(H1, out, outOff);
    unpackWord(H2, out, outOff + 4);
    unpackWord(H3, out, outOff + 8);
    unpackWord(H4, out, outOff + 12);
    unpackWord(H5, out, outOff + 16);
    unpackWord(H6, out, outOff + 20);
    unpackWord(H7, out, outOff + 24);
    unpackWord(H8, out, outOff + 28);
    
    reset();
    
    return 32;
  }
  



  public void reset()
  {
    super.reset();
    





    H1 = 1779033703;
    H2 = -1150833019;
    H3 = 1013904242;
    H4 = -1521486534;
    H5 = 1359893119;
    H6 = -1694144372;
    H7 = 528734635;
    H8 = 1541459225;
    
    xOff = 0;
    for (int i = 0; i != X.length; i++)
    {
      X[i] = 0;
    }
  }
  



  protected void processBlock()
  {
    for (int t = 16; t <= 63; t++)
    {
      X[t] = (Theta1(X[(t - 2)]) + X[(t - 7)] + Theta0(X[(t - 15)]) + X[(t - 16)]);
    }
    



    int a = H1;
    int b = H2;
    int c = H3;
    int d = H4;
    int e = H5;
    int f = H6;
    int g = H7;
    int h = H8;
    
    int t = 0;
    for (int i = 0; i < 8; i++)
    {

      h += Sum1(e) + Ch(e, f, g) + K[t] + X[(t++)];
      d += h;
      h += Sum0(a) + Maj(a, b, c);
      

      g += Sum1(d) + Ch(d, e, f) + K[t] + X[(t++)];
      c += g;
      g += Sum0(h) + Maj(h, a, b);
      

      f += Sum1(c) + Ch(c, d, e) + K[t] + X[(t++)];
      b += f;
      f += Sum0(g) + Maj(g, h, a);
      

      e += Sum1(b) + Ch(b, c, d) + K[t] + X[(t++)];
      a += e;
      e += Sum0(f) + Maj(f, g, h);
      

      d += Sum1(a) + Ch(a, b, c) + K[t] + X[(t++)];
      h += d;
      d += Sum0(e) + Maj(e, f, g);
      

      c += Sum1(h) + Ch(h, a, b) + K[t] + X[(t++)];
      g += c;
      c += Sum0(d) + Maj(d, e, f);
      

      b += Sum1(g) + Ch(g, h, a) + K[t] + X[(t++)];
      f += b;
      b += Sum0(c) + Maj(c, d, e);
      

      a += Sum1(f) + Ch(f, g, h) + K[t] + X[(t++)];
      e += a;
      a += Sum0(b) + Maj(b, c, d);
    }
    
    H1 += a;
    H2 += b;
    H3 += c;
    H4 += d;
    H5 += e;
    H6 += f;
    H7 += g;
    H8 += h;
    



    xOff = 0;
    for (int i = 0; i < 16; i++)
    {
      X[i] = 0;
    }
  }
  




  private int Ch(int x, int y, int z)
  {
    return x & y ^ (x ^ 0xFFFFFFFF) & z;
  }
  



  private int Maj(int x, int y, int z)
  {
    return x & y ^ x & z ^ y & z;
  }
  

  private int Sum0(int x)
  {
    return (x >>> 2 | x << 30) ^ (x >>> 13 | x << 19) ^ (x >>> 22 | x << 10);
  }
  

  private int Sum1(int x)
  {
    return (x >>> 6 | x << 26) ^ (x >>> 11 | x << 21) ^ (x >>> 25 | x << 7);
  }
  

  private int Theta0(int x)
  {
    return (x >>> 7 | x << 25) ^ (x >>> 18 | x << 14) ^ x >>> 3;
  }
  

  private int Theta1(int x)
  {
    return (x >>> 17 | x << 15) ^ (x >>> 19 | x << 13) ^ x >>> 10;
  }
  




  static final int[] K = {
    1116352408, 1899447441, -1245643825, -373957723, 961987163, 1508970993, -1841331548, -1424204075, 
    -670586216, 310598401, 607225278, 1426881987, 1925078388, -2132889090, -1680079193, -1046744716, 
    -459576895, -272742522, 264347078, 604807628, 770255983, 1249150122, 1555081692, 1996064986, 
    -1740746414, -1473132947, -1341970488, -1084653625, -958395405, -710438585, 113926993, 338241895, 
    666307205, 773529912, 1294757372, 1396182291, 1695183700, 1986661051, -2117940946, -1838011259, 
    -1564481375, -1474664885, -1035236496, -949202525, -778901479, -694614492, -200395387, 275423344, 430227734, 506948616, 659060556, 883997877, 958139571, 1322822218, 1537002063, 1747873779, 
    1955562222, 2024104815, -2067236844, -1933114872, -1866530822, -1538233109, -1090935817, -965641998 };
}
